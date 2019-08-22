package com.apps.mkacik.rentbicycle.utilities

import android.app.Application


class App : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this@App))
            .roomModule(RoomModule(this@App))
            .build()
    }

    fun getMyAppComponent(): AppComponent {
        return appComponent
    }
}