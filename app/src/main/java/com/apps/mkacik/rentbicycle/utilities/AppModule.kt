package com.apps.mkacik.rentbicycle.utilities

import android.app.Application
import dagger.Module
import dagger.Provides


@Module
class AppModule(application: Application) {

    private val mApplication: Application = application

    @Provides
    fun providesApplication(): Application {
        return mApplication
    }

}