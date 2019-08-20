package com.apps.mkacik.rentbicycle.viewModels

import androidx.lifecycle.ViewModel
import com.apps.mkacik.rentbicycle.data.BicycleLoadingProvider
import com.apps.mkacik.rentbicycle.data.BicyclesRepository
import com.apps.mkacik.rentbicycle.data.database.entity.Rent

class RentedInfoViewModel(private val repository: BicycleLoadingProvider) : ViewModel() {

    fun endRent(rent: Rent, callBack: BicycleLoadingProvider.EndRentCallBack) {
        repository.endRent(rent, callBack)
    }
}