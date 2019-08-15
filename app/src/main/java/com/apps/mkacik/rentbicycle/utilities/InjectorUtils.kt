package com.apps.mkacik.rentbicycle.utilities

import com.apps.mkacik.rentbicycle.ViewModels.BicyclesViewModelFactory
import com.apps.mkacik.rentbicycle.data.Repository
import com.apps.mkacik.rentbicycle.data.database.AppDatabase

object InjectorUtils {

    fun provideBicyclesViewModelFactory(): BicyclesViewModelFactory{
        val bicycleRepository = Repository.getInstance(AppDatabase.invoke(App.applicationContext()).rentBicycleDAO())
        return BicyclesViewModelFactory(bicycleRepository)
    }
}