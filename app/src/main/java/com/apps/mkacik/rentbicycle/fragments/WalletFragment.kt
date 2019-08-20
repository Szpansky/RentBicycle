package com.apps.mkacik.rentbicycle.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.apps.mkacik.rentbicycle.R
import com.apps.mkacik.rentbicycle.data.AppSharedPref
import com.apps.mkacik.rentbicycle.dialogs.WalletChargeDialog
import kotlinx.android.synthetic.main.fragment_wallet.*
import kotlinx.android.synthetic.main.wallet_status_layout.view.*

class WalletFragment : Fragment() {

    companion object {
        val TAG = "WalletFragment"

        fun newInstance(): WalletFragment {
            return WalletFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initWallet()
        onButtonClick()
    }

    private fun onButtonClick() {
        add_cash_button.setOnClickListener {
            WalletChargeDialog.newInstance().show(fragmentManager, WalletChargeDialog.TAG.toString())
        }
    }

    fun initWallet() {
        val split = AppSharedPref().getWalletCash(requireActivity().baseContext).toString().split(".")

        wallet_view.cashInteger.text = split[0]
        wallet_view.cashIntegerExtend.text = resources.getString(R.string.integer_extend)
        wallet_view.cashRest.text = split[1].take(2)
        wallet_view.cashRestExtend.text = resources.getString(R.string.rest_extend)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_wallet, container, false)
        return view
    }


}