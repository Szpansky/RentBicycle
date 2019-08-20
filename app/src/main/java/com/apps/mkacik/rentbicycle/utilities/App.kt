package com.apps.mkacik.rentbicycle.utilities

import android.app.Application
import android.content.Context

/**
 * TMP CLass for getting context
 */
class App : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: App? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

}