package com.apps.mkacik.rentbicycle.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.apps.mkacik.rentbicycle.R
import com.apps.mkacik.rentbicycle.data.database.entity.BicycleEntity
import com.apps.mkacik.rentbicycle.data.database.entity.Rent
import com.apps.mkacik.rentbicycle.utilities.SimpleFunction
import kotlinx.android.synthetic.main.fragment_rent_info.*

class RentedBicycleActivity : AppCompatActivity() {

    lateinit var rent: Rent

    companion object {
        const val RENT = "RENT"

        fun newIntent(context: Context, rent: Rent): Intent {
            val intent = Intent(context, RentedBicycleActivity::class.java)
            intent.putExtra(RENT, rent)
            return intent
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_rent_info)

        rent = if (savedInstanceState == null) {
            intent.getSerializableExtra(RENT) as Rent
        } else {
            savedInstanceState.getSerializable(RENT) as Rent
        }

        setRentInfo(rent)
    }


    @SuppressLint("SetTextI18n")
    private fun setRentInfo(rent: Rent) {

        val price = SimpleFunction.testCalculatePriceFromDate(rent.dateStart, rent.price)
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


    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        outState.putSerializable(RENT, rent)
        super.onSaveInstanceState(outState, outPersistentState)
    }


}
