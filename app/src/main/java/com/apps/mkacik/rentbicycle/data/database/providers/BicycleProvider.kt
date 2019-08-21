package com.apps.mkacik.rentbicycle.data.database.providers

import androidx.lifecycle.LiveData
import com.apps.mkacik.rentbicycle.data.database.entity.BicycleEntity

interface BicycleProvider {

    fun editBicycle(bicycle: BicycleEntity, editCallBack: EditCallBack)

    interface EditCallBack {
        fun onSuccess()
        fun onFail(throwable: Throwable)
    }

    fun addBicycles(bicycles: List<BicycleEntity>, addListCallBack: AddListCallBack)

    interface AddListCallBack {
        fun onSuccess()
        fun onFail(throwable: Throwable)
    }

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

    fun getBicycles(): LiveData<List<BicycleEntity>>

}