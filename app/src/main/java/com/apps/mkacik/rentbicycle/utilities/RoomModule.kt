package com.apps.mkacik.rentbicycle.utilities

import android.content.Context
import androidx.room.Room
import com.apps.mkacik.rentbicycle.data.database.repository.BicyclesRepository
import com.apps.mkacik.rentbicycle.data.database.AppDatabase
import com.apps.mkacik.rentbicycle.data.database.dao.DatabaseDAO
import com.apps.mkacik.rentbicycle.viewModels.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RoomModule {


    /**
     * TMP
     */
    @Provides
    fun provideDatabase(context: Context): AppDatabase = invoke(context)


    @Module
    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()
        const val NAME = "RentBicycleDatabase.db"

        operator fun invoke(context: Context) =
            instance
                ?: synchronized(LOCK) {
                    instance
                        ?: buildDatabase(context).also { instance = it }
                }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            NAME
        ).allowMainThreadQueries()
            .build()

    }


    @Provides
    fun providesDatabaseDao(appDatabase: AppDatabase): DatabaseDAO {
        return appDatabase.databaseDao()
    }


    @Provides
    fun providesBicycleRepository(databaseDao: DatabaseDAO): BicyclesRepository {
        return BicyclesRepository(databaseDao)
    }


    @Provides
    fun providesVMBicycle(bicyclesRepository: BicyclesRepository): ViewModelFactory.Bicycles {
        return ViewModelFactory.Bicycles(bicyclesRepository)
    }

    @Provides
    fun providesVMBRentedBicycles(bicyclesRepository: BicyclesRepository): ViewModelFactory.RentedBicycles {
        return ViewModelFactory.RentedBicycles(bicyclesRepository)
    }

    @Provides
    fun providesVMRentedInfo(bicyclesRepository: BicyclesRepository): ViewModelFactory.RentedInfo {
        return ViewModelFactory.RentedInfo(bicyclesRepository)
    }

}