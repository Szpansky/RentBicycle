package com.apps.mkacik.rentbicycle.viewModels

import androidx.lifecycle.ViewModel
import com.apps.mkacik.rentbicycle.data.LoadingProvider
import com.apps.mkacik.rentbicycle.data.database.providers.RentProvider

class RentedViewModel(private val bicyclesRepository: LoadingProvider) : ViewModel() {

    fun getRentedBicycles(getRentBicyclesCallBack: RentProvider.GetRentBicyclesCallBack) {
        bicyclesRepository.getRentBicycles(getRentBicyclesCallBack)
    }

}