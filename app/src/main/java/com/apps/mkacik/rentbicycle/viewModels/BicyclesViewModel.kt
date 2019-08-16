package com.apps.mkacik.rentbicycle.viewModels

import androidx.lifecycle.ViewModel
import com.apps.mkacik.rentbicycle.data.BicycleLoadingProvider
import com.apps.mkacik.rentbicycle.data.database.entity.BicycleEntity

class BicyclesViewModel(private val bicyclesRepository: BicycleLoadingProvider) : ViewModel() {


    fun addBicycle(bicycle: BicycleEntity, addCallBack: BicycleLoadingProvider.AddCallBack) {
        bicyclesRepository.addBicycle(bicycle, addCallBack)
    }

    fun getBicycles(getCallBack: BicycleLoadingProvider.GetCallBack) {
        bicyclesRepository.getBicycles(getCallBack)
    }

    fun rentBicycle(bicycle: BicycleEntity, rentCallBack: BicycleLoadingProvider.RentCallBack) {
        bicyclesRepository.rentBicycle(bicycle, rentCallBack)
    }
}