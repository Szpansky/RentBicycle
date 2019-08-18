package com.apps.mkacik.rentbicycle.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.apps.mkacik.rentbicycle.R
import com.apps.mkacik.rentbicycle.data.AppSharedPref
import com.apps.mkacik.rentbicycle.data.BicycleLoadingProvider
import com.apps.mkacik.rentbicycle.data.database.entity.BicycleEntity
import com.apps.mkacik.rentbicycle.data.database.entity.Rent
import com.apps.mkacik.rentbicycle.utilities.InjectorUtils
import com.apps.mkacik.rentbicycle.utilities.SimpleFunction
import com.apps.mkacik.rentbicycle.viewModels.RentedInfoViewModel
import kotlinx.android.synthetic.main.fragment_rent_info.*
import java.util.*
import kotlin.concurrent.fixedRateTimer
import kotlin.properties.Delegates


class RentedBicycleActivity : AppCompatActivity() {

    private lateinit var viewModel: RentedInfoViewModel
    lateinit var rent: Rent
    lateinit var timer: Timer

    var price: Float by Delegates.observable(0F) { _, _, newValue ->
        rent_price.text = String.format("%.2f ${getString(R.string.integer_extend)}", newValue)
    }

    companion object {
        const val RENT = "RENT"
        const val PRICE = "PRICE"

        fun newIntent(context: Context, rent: Rent): Intent {
            val intent = Intent(context, RentedBicycleActivity::class.java)
            intent.putExtra(RENT, rent)
            return intent
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        rent = savedInstanceState.getSerializable(RENT) as Rent
        price = savedInstanceState.getFloat(PRICE)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(RENT, rent)
        outState.putFloat(PRICE, price)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_rent_info)

        val factory = InjectorUtils.provideRentedInfoViewModelFactory()
        viewModel = ViewModelProviders.of(this, factory).get(RentedInfoViewModel::class.java)

        if (savedInstanceState == null) {
            rent = intent.getSerializableExtra(RENT) as Rent

        } else {
            rent = savedInstanceState.getSerializable(RENT) as Rent
        }
        setRentInfo(rent)
        oneSecRefresh(rent)

        end_rent_button.setOnClickListener {
            viewModel.endRent(rent, object : BicycleLoadingProvider.EndRentCallBack {
                override fun onSuccess() {
                    AppSharedPref().saveWalletCash(
                        AppSharedPref().getWalletCash(applicationContext) - price,
                        applicationContext
                    )
                    onBackPressed()
                }

                override fun onFail(throwable: Throwable) {
                    Toast.makeText(applicationContext, throwable.message, Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    private fun oneSecRefresh(rent: Rent) {
        timer = fixedRateTimer("timer", false, 0, 2000) {
            this@RentedBicycleActivity.runOnUiThread {
                price = SimpleFunction.testCalculatePriceFromDate(rent.dateStart, rent.price)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }

    @SuppressLint("SetTextI18n")
    private fun setRentInfo(rent: Rent) {
        rent_price.text = String.format("%.2f ${getString(R.string.integer_extend)}", price)
        bicycle_id_top.text = rent.bicycleId.toString()
        bicycle_id.text = rent.bicycleId.toString()
        bicycle_color.text = rent.color
        bicycle_brand.text = rent.brand
        rent_time_start.text = rent.dateStart
        bicycle_price.text = String.format("%.2f ${getString(R.string.integer_extend)}", rent.price)

        bicycle_availability.text = if (rent.availability)
            getString(BicycleEntity.BICYCLE_AVAILABILITY_TRUE)
        else
            getString(BicycleEntity.BICYCLE_AVAILABILITY_FALSE)
    }
}
