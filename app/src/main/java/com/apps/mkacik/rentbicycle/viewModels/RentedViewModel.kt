package com.apps.mkacik.rentbicycle.viewModels

import androidx.lifecycle.ViewModel
import com.apps.mkacik.rentbicycle.data.BicycleLoadingProvider

class RentedViewModel(private val bicyclesRepository: BicycleLoadingProvider) : ViewModel() {

    fun getRentedBicycles(getRentBicyclesCallBack: BicycleLoadingProvider.GetRentBicyclesCallBack) {
        bicyclesRepository.getRentBicycles(getRentBicyclesCallBack)
    }

}