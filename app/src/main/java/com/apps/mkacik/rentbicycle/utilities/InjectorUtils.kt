package com.apps.mkacik.rentbicycle.utilities

import com.apps.mkacik.rentbicycle.viewModels.ViewModelFactory

object InjectorUtils {

    fun provideRentedInfoViewModelFactory(): ViewModelFactory.RentedInfo {
        val bicycleRepository = DaggerAppComponent.builder().build().providesBicycleRepository()
        return ViewModelFactory.RentedInfo(bicycleRepository)
    }

    fun provideRentedViewModelFactory(): ViewModelFactory.RentedBicycles {
        val bicycleRepository = DaggerAppComponent.builder().build().providesBicycleRepository()
        return ViewModelFactory.RentedBicycles(bicycleRepository)
    }


    fun provideBicyclesViewModelFactory(): ViewModelFactory.Bicycles {
        val bicycleRepository = DaggerAppComponent.builder().build().providesBicycleRepository()
        return ViewModelFactory.Bicycles(bicycleRepository)
    }
}