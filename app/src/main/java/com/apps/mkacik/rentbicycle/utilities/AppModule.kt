package com.apps.mkacik.rentbicycle.utilities

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule {


    var mApplication: Application

    constructor (application: Application) {
        mApplication = application
    }

    @Provides
    @Singleton
    fun providesApplication(): Application {
        return mApplication
    }
}