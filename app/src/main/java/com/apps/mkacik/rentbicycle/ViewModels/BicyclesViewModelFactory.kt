package com.apps.mkacik.rentbicycle.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.apps.mkacik.rentbicycle.data.Repository

class BicyclesViewModelFactory(private val repository: Repository):ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BicyclesViewModel(repository) as T
    }
}