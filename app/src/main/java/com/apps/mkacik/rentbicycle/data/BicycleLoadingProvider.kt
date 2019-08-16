package com.apps.mkacik.rentbicycle.data

import androidx.lifecycle.LiveData
import com.apps.mkacik.rentbicycle.data.database.entity.BicycleEntity

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
}