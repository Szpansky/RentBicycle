package com.apps.mkacik.rentbicycle.dependencies

import android.app.Application
import dagger.Module
import dagger.Provides


@Module
class AppModule(val application: Application) {


    @Provides
    fun providesApplication(): Application {
        return application
    }
}