package com.apps.mkacik.rentbicycle.utilities

import com.apps.mkacik.rentbicycle.viewModels.BicyclesViewModelFactory
import com.apps.mkacik.rentbicycle.data.BicyclesRepository
import com.apps.mkacik.rentbicycle.data.database.AppDatabase

object InjectorUtils {

    fun provideBicyclesViewModelFactory(): BicyclesViewModelFactory{
        val bicycleRepository = BicyclesRepository.getInstance(AppDatabase.invoke(App.applicationContext()).rentBicycleDAO())
        return BicyclesViewModelFactory(bicycleRepository)
    }
}