package com.apps.mkacik.rentbicycle.data.database.providers

import androidx.lifecycle.LiveData
import com.apps.mkacik.rentbicycle.data.database.entity.BicycleEntity
import com.apps.mkacik.rentbicycle.data.database.model.Rent

interface RentProvider {

    fun endRent(rent: Rent, endRentCallBack: EndRentCallBack)

    interface EndRentCallBack {
        fun onSuccess()
        fun onFail(throwable: Throwable)
    }

    fun rentBicycle(bicycle: BicycleEntity, rentCallBack: RentCallBack)

    interface RentCallBack {
        fun onSuccess()
        fun onFail(throwable: Throwable)
    }

    fun getRentBicycles(rentBicyclesCallBack: GetRentBicyclesCallBack)

    interface GetRentBicyclesCallBack {
        fun onSuccess(bicycleList: LiveData<List<Rent>>)
        fun onFail(throwable: Throwable)
    }
}