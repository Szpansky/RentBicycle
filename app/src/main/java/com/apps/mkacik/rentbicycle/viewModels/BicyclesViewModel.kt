package com.apps.mkacik.rentbicycle.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.apps.mkacik.rentbicycle.data.LoadingProvider
import com.apps.mkacik.rentbicycle.data.database.entity.BicycleEntity
import com.apps.mkacik.rentbicycle.data.database.providers.BicycleProvider
import com.apps.mkacik.rentbicycle.data.database.providers.RentProvider


class BicyclesViewModel(private val bicyclesRepository: LoadingProvider) : ViewModel() {

    fun getLiveData(): LiveData<List<BicycleEntity>> {
        return bicyclesRepository.getBicycles()
    }


    fun getBicycles(getCallBack: BicycleProvider.GetCallBack) {
        bicyclesRepository.getBicycles(getCallBack)
    }


    fun rentBicycle(bicycle: BicycleEntity, rentCallBack: RentProvider.RentCallBack) {
        bicyclesRepository.rentBicycle(bicycle, rentCallBack)
    }
}