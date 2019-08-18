package com.apps.mkacik.rentbicycle.dialogs

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.apps.mkacik.rentbicycle.R
import com.apps.mkacik.rentbicycle.data.AppSharedPref
import com.apps.mkacik.rentbicycle.data.BicycleLoadingProvider
import com.apps.mkacik.rentbicycle.data.BicyclesRepository
import com.apps.mkacik.rentbicycle.data.database.AppDatabase
import com.apps.mkacik.rentbicycle.data.database.entity.BicycleEntity
import com.apps.mkacik.rentbicycle.utilities.App
import kotlinx.android.synthetic.main.dialog_first_run.*
import java.math.BigDecimal
import java.math.RoundingMode

class FirstRunDialog : DialogFragment() {

    private var lock = true

    companion object {
        val TAG = this::class.java

        fun newInstance(): FirstRunDialog {
            val dialog = FirstRunDialog()

            dialog.setStyle(STYLE_NO_TITLE, R.style.TransparentDialogNoDismissible)

            return dialog
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onButtonClick()
    }

    private fun onButtonClick() {
        start_button.setOnClickListener {
            if (isCorrectNumber(start_cash.text.toString())) {

                val decimal: BigDecimal = try {
                    BigDecimal(start_cash.text.toString()).setScale(2, RoundingMode.HALF_EVEN)
                } catch (t: NumberFormatException) {
                    BigDecimal.ZERO
                }

                AppSharedPref().saveWalletCash(decimal.toFloat(), requireContext().applicationContext)
                lock = false
                dismiss()
            } else {
                start_cash.error = "Too many dots"
            }
        }
    }

    private fun isCorrectNumber(string: String): Boolean {
        return string.split(".").size <= 2
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.dialog_first_run, container, false)

        return view
    }

    //TODO change to false
    override fun onDismiss(dialog: DialogInterface?) {
        super.onDismiss(dialog)
        if (!lock) {
            AppSharedPref().saveFirstRun(true, requireContext().applicationContext)
            createStartItems()
        }
    }

    private fun createStartItems() {
        val bicycleRepository = BicyclesRepository.getInstance(AppDatabase.invoke(requireContext().applicationContext).rentBicycleDAO())
        bicycleRepository.deleteData()
        val bicycles : List<BicycleEntity> = listOf(
            BicycleEntity(false,2.2F,"Red","Cross"),
            BicycleEntity(true,1.2F,"Blue","Cross"),
            BicycleEntity(false,1.6F,"Red","Cross"),
            BicycleEntity(false,3.2F,"Green","Cross"),
            BicycleEntity(true,1.7F,"Red","Cross"),
            BicycleEntity(false,2.2F,"Unnamed","Dirty"),
            BicycleEntity(false,1.2F,"Red","Kajak"),
            BicycleEntity(false,0.2F,"Black","Goral"),
            BicycleEntity(false,1.4F,"Red","Dirty"),
            BicycleEntity(true,1.9F,"Pink","Rover")
        )

        bicycleRepository.addBicycles(bicycles,object : BicycleLoadingProvider.AddListCallBack{
            override fun onSuccess() {
            }

            override fun onFail(throwable: Throwable) {
            }
        } )
    }
}