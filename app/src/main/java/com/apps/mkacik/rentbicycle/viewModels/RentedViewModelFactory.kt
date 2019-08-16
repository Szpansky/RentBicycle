package com.apps.mkacik.rentbicycle.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.apps.mkacik.rentbicycle.data.BicyclesRepository

class RentedViewModelFactory(private val bicyclesRepository: BicyclesRepository): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RentedViewModel(bicyclesRepository) as T
    }
}
