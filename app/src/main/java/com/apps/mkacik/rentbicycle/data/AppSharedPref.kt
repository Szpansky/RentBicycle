package com.apps.mkacik.rentbicycle.data

import android.content.Context
import android.content.SharedPreferences

class AppSharedPref {

    companion object {
        const val USER_DATA = "USER_DATA"
        const val WALLET = "WALLET"
        const val FIRST_RUN = "FIRST_RUN"
    }

    fun getWalletCash(context: Context): Float {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(USER_DATA, Context.MODE_PRIVATE)
        return sharedPreferences.getFloat(WALLET, 0.0F)
    }

    fun saveWalletCash(cash: Float, context: Context) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(USER_DATA, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putFloat(WALLET, cash)
        editor.apply()
    }

    fun isFirstRun(context: Context): Boolean {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(USER_DATA, Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean(FIRST_RUN, true)
    }

    fun saveFirstRun(state: Boolean, context: Context) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(USER_DATA, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean(FIRST_RUN, state)
        editor.apply()
    }
}