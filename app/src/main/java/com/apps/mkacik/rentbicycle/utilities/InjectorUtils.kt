package com.apps.mkacik.rentbicycle.utilities

import com.apps.mkacik.rentbicycle.viewModels.BicyclesViewModelFactory
import com.apps.mkacik.rentbicycle.data.BicyclesRepository
import com.apps.mkacik.rentbicycle.data.database.AppDatabase
import com.apps.mkacik.rentbicycle.viewModels.RentedViewModel
import com.apps.mkacik.rentbicycle.viewModels.RentedViewModelFactory

object InjectorUtils {

    fun provideBicyclesViewModelFactory(): BicyclesViewModelFactory{
        val bicycleRepository = BicyclesRepository.getInstance(AppDatabase.invoke(App.applicationContext()).rentBicycleDAO())
        return BicyclesViewModelFactory(bicycleRepository)
    }

    fun provideRentedViewModelFactory(): RentedViewModelFactory{
        val bicycleRepository = BicyclesRepository.getInstance(AppDatabase.invoke(App.applicationContext()).rentBicycleDAO())
        return RentedViewModelFactory(bicycleRepository)
    }
}