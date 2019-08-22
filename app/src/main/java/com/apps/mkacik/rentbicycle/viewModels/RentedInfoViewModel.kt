package com.apps.mkacik.rentbicycle.viewModels

import androidx.lifecycle.ViewModel
import com.apps.mkacik.rentbicycle.data.LoadingProvider
import com.apps.mkacik.rentbicycle.data.database.model.Rent
import com.apps.mkacik.rentbicycle.data.database.providers.RentProvider

class RentedInfoViewModel(private val repository: LoadingProvider) : ViewModel() {

    fun endRent(rent: Rent, callBack: RentProvider.EndRentCallBack) {
        repository.endRent(rent, callBack)
    }
}