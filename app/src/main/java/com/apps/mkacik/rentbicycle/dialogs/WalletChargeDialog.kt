package com.apps.mkacik.rentbicycle.dialogs

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.apps.mkacik.rentbicycle.R
import com.apps.mkacik.rentbicycle.data.AppSharedPref
import com.apps.mkacik.rentbicycle.fragments.WalletFragment
import kotlinx.android.synthetic.main.dialog_wallet_charge.*

class WalletChargeDialog : DialogFragment() {

    companion object {
        val TAG = WalletChargeDialog::class.java

        fun newInstance(): WalletChargeDialog {
            val dialog = WalletChargeDialog()
            dialog.setStyle(STYLE_NO_TITLE, R.style.TransparentDialog)
            return dialog
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_wallet_charge, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val walletCash = AppSharedPref().getWalletCash(requireContext().applicationContext)

        if (walletCash < 99999F) {
            add_5_button.setOnClickListener { addCash(walletCash + 5F) }
            add_10_button.setOnClickListener { addCash(walletCash + 10F) }
            add_25_button.setOnClickListener { addCash(walletCash + 25F) }
            add_50_button.setOnClickListener { addCash(walletCash + 50F) }
        } else {
            Toast.makeText(requireContext().applicationContext, "Max Cash In Wallet", Toast.LENGTH_SHORT).show()
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
        (fragmentManager?.findFragmentByTag(WalletFragment.TAG) as? WalletFragment)?.initWallet()
    }
}