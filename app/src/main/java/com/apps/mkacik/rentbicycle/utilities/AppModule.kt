package com.apps.mkacik.rentbicycle.utilities

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule {

    private var mContext: Context

    constructor(context: Context) {
        mContext = context
    }

    @Provides
    @Singleton
    fun providesApplication(): Context {
        return mContext
    }

}