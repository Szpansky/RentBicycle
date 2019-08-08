package com.apps.mkacik.rentbicycle.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apps.mkacik.rentbicycle.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onMenuClick()
    }

    private fun onMenuClick() {
        rentButton.setOnClickListener {
            startActivity(
                RentBicycleActivity.startActivity(
                    this
                )
            )
        }
        listButton.setOnClickListener {
            startActivity(
                MyBicycleActivity.startActivity(
                    this
                )
            )
        }
        walletButton.setOnClickListener {
            startActivity(
                WalletActivity.startActivity(
                    this
                )
            )
        }
    }

}
