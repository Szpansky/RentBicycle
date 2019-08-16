package com.apps.mkacik.rentbicycle.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.apps.mkacik.rentbicycle.data.BicyclesRepository

class BicyclesViewModelFactory(private val bicyclesRepository: BicyclesRepository):ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BicyclesViewModel(bicyclesRepository) as T
    }
}