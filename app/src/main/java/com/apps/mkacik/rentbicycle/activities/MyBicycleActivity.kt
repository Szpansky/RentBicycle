package com.apps.mkacik.rentbicycle.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apps.mkacik.rentbicycle.R

class MyBicycleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_bicycle)
    }

    companion object {
        fun startActivity(context: Context): Intent {
            return Intent(context, MyBicycleActivity::class.java)
        }
    }
}
