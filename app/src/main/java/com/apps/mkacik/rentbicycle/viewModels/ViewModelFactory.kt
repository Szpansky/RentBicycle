package com.apps.mkacik.rentbicycle.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.apps.mkacik.rentbicycle.data.database.repository.BicyclesRepository
import javax.inject.Inject


class ViewModelFactory @Inject constructor() {

    class Factory @Inject constructor(private val bicyclesRepository: BicyclesRepository) :
        ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {

            if (modelClass.isAssignableFrom(BicyclesViewModel::class.java))
                return BicyclesViewModel(bicyclesRepository) as T
            else if (modelClass.isAssignableFrom(RentedViewModel::class.java))
                return RentedViewModel(bicyclesRepository) as T
            else if (modelClass.isAssignableFrom(RentedInfoViewModel::class.java))
                return RentedInfoViewModel(bicyclesRepository) as T
            else throw IllegalArgumentException("Cant provide that VM for you")
        }
    }
}