package com.apps.mkacik.rentbicycle.data

import androidx.lifecycle.LiveData
import com.apps.mkacik.rentbicycle.data.database.entity.BicycleEntity
import com.apps.mkacik.rentbicycle.data.database.entity.RentEntity

interface BicycleLoadingProvider {

    fun addBicycle(bicycle: BicycleEntity, addCallBack: AddCallBack)

    interface AddCallBack {
        fun onSuccess()
        fun onFail(throwable: Throwable)
    }

    fun getBicycles(getCallBack: GetCallBack)

    interface GetCallBack {
        fun onSuccess(bicycleList: LiveData<List<BicycleEntity>>)
        fun onFail(throwable: Throwable)
    }

    fun rentBicycle(bicycle: BicycleEntity, rentCallBack: RentCallBack)

    interface RentCallBack {
        fun onSuccess()
        fun onFail(throwable: Throwable)
    }

    fun getRentBicycles(rentBicyclesCallBack: GetRentBicyclesCallBack)

    interface GetRentBicyclesCallBack {
        fun onSuccess(bicycleList: LiveData<List<RentEntity>>)
        fun onFail(throwable: Throwable)
    }
}