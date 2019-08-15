package com.apps.mkacik.rentbicycle.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.apps.mkacik.rentbicycle.R

class WalletFragment : Fragment() {

    companion object {
        val TAG = this::class.java.name

        fun newInstance(): WalletFragment {
            return WalletFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_wallet, container, false)
        return view
    }
}