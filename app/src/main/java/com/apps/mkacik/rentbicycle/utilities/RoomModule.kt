package com.apps.mkacik.rentbicycle.utilities

import android.app.Application
import androidx.room.Room
import com.apps.mkacik.rentbicycle.data.BicycleDataSource
import com.apps.mkacik.rentbicycle.data.BicycleRepo
import com.apps.mkacik.rentbicycle.data.database.model.DatabaseDAO
import com.apps.mkacik.rentbicycle.data.database.repository.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RoomModule {
    
    private var appDatabase : AppDatabase

    constructor(application: Application){
        appDatabase = buildDatabase(application)
    }


    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()
        const val NAME = "RentBicycleDatabase.db"

        operator fun invoke(application: Application) =
            instance
                ?: synchronized(LOCK) {
                    instance
                        ?: buildDatabase(
                            application
                        ).also { instance = it }
                }

        private fun buildDatabase(application: Application) = Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            NAME
        ).allowMainThreadQueries()
            .build()
    }


    @Singleton
    @Provides
    fun provideRoomDatabase() : AppDatabase{
        return appDatabase
    }


    @Singleton
    @Provides
    fun providesDatabaseDao(appDatabase: AppDatabase) : DatabaseDAO{
        return appDatabase.rentBicycleDAO()
    }

    @Singleton
    @Provides
    fun bicycleRepo(databaseDAO: DatabaseDAO) : BicycleRepo{
        return BicycleDataSource(databaseDAO)
    }

}