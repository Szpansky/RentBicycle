package com.apps.mkacik.rentbicycle.utilities

import android.app.Application
import com.apps.mkacik.rentbicycle.dependencies.AppComponent
import com.apps.mkacik.rentbicycle.dependencies.AppModule
import com.apps.mkacik.rentbicycle.dependencies.DaggerAppComponent


class App : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this@App))
            .build()
    }

    fun getMyAppComponent(): AppComponent {
        return appComponent
    }
}