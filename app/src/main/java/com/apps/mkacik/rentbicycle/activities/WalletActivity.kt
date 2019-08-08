package com.apps.mkacik.rentbicycle.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apps.mkacik.rentbicycle.R
import kotlinx.android.synthetic.main.activity_wallet.*

class WalletActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet)
        onMenuClick()
    }

    companion object {
        fun startActivity(context: Context): Intent {
            return Intent(context, WalletActivity::class.java)
        }
    }

    private fun onMenuClick(){
        backButton.setOnClickListener {
            this.onBackPressed()
        }
    }
}
