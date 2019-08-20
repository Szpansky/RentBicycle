package com.apps.mkacik.rentbicycle.dialogs

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.apps.mkacik.rentbicycle.R
import com.apps.mkacik.rentbicycle.data.AppSharedPref
import kotlinx.android.synthetic.main.dialog_first_run.*
import java.math.BigDecimal
import java.math.RoundingMode

class FirstRunDialog : DialogFragment() {

    private lateinit var firstRunDialogInterface: FirstRunDialogInterface

    interface FirstRunDialogInterface {
        fun prepareDatabase()
    }

    private var lock = true

    companion object {
        const val TAG = "FirstRunDialog"

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
        return inflater.inflate(R.layout.dialog_first_run, container, false)
    }


    override fun onDismiss(dialog: DialogInterface?) {
        super.onDismiss(dialog)
        if (!lock) {
            AppSharedPref().saveFirstRun(false, requireContext().applicationContext)
            firstRunDialogInterface.prepareDatabase()
        }
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is FirstRunDialogInterface) {
            firstRunDialogInterface = context
        } else {
            Log.e(FirstRunDialog::class.java.name, "Need to implement FirstRunDialogInterface from FirstRunDialog")
        }
    }
}