package com.apps.mkacik.rentbicycle.utilities

import android.content.Context
import com.apps.mkacik.rentbicycle.data.database.repository.BicyclesRepository
import com.apps.mkacik.rentbicycle.data.database.AppDatabase
import com.apps.mkacik.rentbicycle.data.database.dao.DatabaseDAO
import com.apps.mkacik.rentbicycle.viewModels.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDatabase {
        return AppDatabase.invoke(context)
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


    @Provides
    @Singleton
    fun providesVMBicycle(bicyclesRepository: BicyclesRepository): ViewModelFactory.Bicycles {
        return ViewModelFactory.Bicycles(bicyclesRepository)
    }

    @Provides
    @Singleton
    fun providesVMBRentedBicycles(bicyclesRepository: BicyclesRepository): ViewModelFactory.RentedBicycles {
        return ViewModelFactory.RentedBicycles(bicyclesRepository)
    }

    @Provides
    @Singleton
    fun providesVMRentedInfo(bicyclesRepository: BicyclesRepository): ViewModelFactory.RentedInfo {
        return ViewModelFactory.RentedInfo(bicyclesRepository)
    }

}