package com.apps.mkacik.rentbicycle.dependencies

import android.app.Application
import androidx.room.Room
import com.apps.mkacik.rentbicycle.data.database.AppDatabase
import com.apps.mkacik.rentbicycle.data.database.dao.DatabaseDAO
import com.apps.mkacik.rentbicycle.data.database.repository.BicyclesRepository
import com.apps.mkacik.rentbicycle.viewModels.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RoomModule {


    @Provides
    @Singleton
    fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            AppDatabase.NAME
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


    @Singleton
    @Provides
    fun providesVMFactory(bicyclesRepository: BicyclesRepository): ViewModelFactory.Factory {
        return ViewModelFactory.Factory(bicyclesRepository)
    }
}