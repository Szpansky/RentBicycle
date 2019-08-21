package com.apps.mkacik.rentbicycle.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.apps.mkacik.rentbicycle.data.BicyclesRepository
import javax.inject.Inject

class ViewModelFactory @Inject constructor() {

    class RentedInfo @Inject constructor(val bicyclesRepository: BicyclesRepository) :
        ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return RentedInfoViewModel(bicyclesRepository) as T
        }
    }


    class RentedBicycles @Inject constructor(val bicyclesRepository: BicyclesRepository) :
        ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return RentedViewModel(bicyclesRepository) as T
        }
    }


    class Bicycles @Inject constructor(val bicyclesRepository: BicyclesRepository) :
        ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return BicyclesViewModel(bicyclesRepository) as T
        }
    }
}