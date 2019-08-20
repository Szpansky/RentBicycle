package com.apps.mkacik.rentbicycle.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.apps.mkacik.rentbicycle.data.BicyclesRepository

class ViewModelFactory {

    class RentedInfo(private val bicyclesRepository: BicyclesRepository) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return RentedInfoViewModel(bicyclesRepository) as T
        }
    }

    class RentedBicycles(private val bicyclesRepository: BicyclesRepository) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return RentedViewModel(bicyclesRepository) as T
        }
    }

    class Bicycles(private val bicyclesRepository: BicyclesRepository) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return BicyclesViewModel(bicyclesRepository) as T
        }
    }
}
