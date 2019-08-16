package com.apps.mkacik.rentbicycle.viewModels

import androidx.lifecycle.ViewModel
import com.apps.mkacik.rentbicycle.data.BicycleLoadingProvider
import com.apps.mkacik.rentbicycle.data.database.entity.BicycleEntity

class BicyclesViewModel(private val repository: BicycleLoadingProvider) : ViewModel() {


    fun addBicycle(bicycle: BicycleEntity, addCallBack: BicycleLoadingProvider.AddCallBack) {
        repository.addBicycle(bicycle, addCallBack)
    }

    fun getBicycles(getCallBack: BicycleLoadingProvider.GetCallBack) {
        repository.getBicycles(getCallBack)
    }

    fun rentBicycle(bicycle: BicycleEntity, rentCallBack: BicycleLoadingProvider.RentCallBack) {
        repository.rentBicycle(bicycle, rentCallBack)
    }
}