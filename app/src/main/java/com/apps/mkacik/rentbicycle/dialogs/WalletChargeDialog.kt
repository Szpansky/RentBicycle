package com.apps.mkacik.rentbicycle.dialogs

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import com.apps.mkacik.rentbicycle.R
import com.apps.mkacik.rentbicycle.data.AppSharedPref
import kotlinx.android.synthetic.main.dialog_wallet_charge.*
import java.io.Serializable

class WalletChargeDialog : DialogFragment() {

    interface OnDismissListener : Serializable {
        fun onDismissWalletCharge()
    }

    var onDismissListener: OnDismissListener? = null


    companion object {
        val TAG = WalletChargeDialog::class.java
        const val CALL_BACK = "CALL_BACK"

        fun newInstance(onDismissListener: OnDismissListener): WalletChargeDialog {
            val dialog = WalletChargeDialog()

            dialog.arguments = bundleOf(
                CALL_BACK to onDismissListener
            )
            dialog.setStyle(STYLE_NO_TITLE, R.style.TransparentDialog)
            return dialog
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.dialog_wallet_charge, container, false)

        onDismissListener = arguments?.get(CALL_BACK) as OnDismissListener?

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val walletCash = AppSharedPref().getWalletCash(requireContext().applicationContext)

        if(walletCash < 99999F) {
            add_5_button.setOnClickListener { addCash(walletCash + 5F) }
            add_10_button.setOnClickListener { addCash(walletCash + 10F) }
            add_25_button.setOnClickListener { addCash(walletCash + 25F) }
            add_50_button.setOnClickListener { addCash(walletCash + 50F) }
        }else{
            Toast.makeText(requireContext().applicationContext,"Max Cash In Wallet", Toast.LENGTH_SHORT).show()
        }
    }

    private fun addCash(walletCash: Float) {
        AppSharedPref().saveWalletCash(
            walletCash,
            requireContext().applicationContext
        )
        this.dismiss()
    }

    override fun onDismiss(dialog: DialogInterface?) {
        super.onDismiss(dialog)
        onDismissListener?.onDismissWalletCharge()
    }
}