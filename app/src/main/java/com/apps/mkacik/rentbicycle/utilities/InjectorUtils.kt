package com.apps.mkacik.rentbicycle.utilities

import com.apps.mkacik.rentbicycle.data.BicyclesRepository
import com.apps.mkacik.rentbicycle.data.database.AppDatabase
import com.apps.mkacik.rentbicycle.viewModels.ViewModelFactory

object InjectorUtils {

    fun provideRentedInfoViewModelFactory(): ViewModelFactory.RentedInfo {
        val bicycleRepository =
            BicyclesRepository.getInstance(AppDatabase.invoke(App.applicationContext()).rentBicycleDAO())
        return ViewModelFactory.RentedInfo(bicycleRepository)
    }

    fun provideBicyclesViewModelFactory(): ViewModelFactory.Bicycles {
        val bicycleRepository =
            BicyclesRepository.getInstance(AppDatabase.invoke(App.applicationContext()).rentBicycleDAO())
        return ViewModelFactory.Bicycles(bicycleRepository)
    }

    fun provideRentedViewModelFactory(): ViewModelFactory.RentedBicycles {
        val bicycleRepository =
            BicyclesRepository.getInstance(AppDatabase.invoke(App.applicationContext()).rentBicycleDAO())
        return ViewModelFactory.RentedBicycles(bicycleRepository)
    }
}