package com.apps.mkacik.rentbicycle.utilities

import androidx.room.Room
import com.apps.mkacik.rentbicycle.data.BicyclesRepository
import com.apps.mkacik.rentbicycle.data.database.AppDatabase
import com.apps.mkacik.rentbicycle.data.database.DatabaseDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideDatabase() = invoke()


    @Module
    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()
        const val NAME = "RentBicycleDatabase.db"

        operator fun invoke() =
            instance
                ?: synchronized(LOCK) {
                    instance
                        ?: buildDatabase().also { instance = it }
                }

        private fun buildDatabase() = Room.databaseBuilder(
            App.applicationContext(),
            AppDatabase::class.java,
            NAME
        ).allowMainThreadQueries()
            .build()

    }


    @Provides
    @Singleton
    fun providesDatabaseDao(appDatabase: AppDatabase): DatabaseDAO {
        return appDatabase.databaseDao()
    }


    @Provides
    @Singleton
    fun providesBicycleRepository(databaseDao: DatabaseDAO): BicyclesRepository {
        return BicyclesRepository(databaseDao)
    }
}