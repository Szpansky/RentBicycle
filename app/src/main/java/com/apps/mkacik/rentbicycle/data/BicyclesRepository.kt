package com.apps.mkacik.rentbicycle.data

import com.apps.mkacik.rentbicycle.data.database.DatabaseDAO
import com.apps.mkacik.rentbicycle.data.database.entity.BicycleEntity

class BicyclesRepository private constructor(private val databaseDAO: DatabaseDAO) : BicycleLoadingProvider {

    override fun addBicycle(bicycle: BicycleEntity, addCallBack: BicycleLoadingProvider.AddCallBack) {
        databaseDAO.saveBicycle(bicycle)
        addCallBack.onSuccess()
    }

    override fun getBicycles(getCallBack: BicycleLoadingProvider.GetCallBack) {
        getCallBack.onSuccess(databaseDAO.getBicycles())
    }

    companion object {
        @Volatile
        private var instance: BicyclesRepository? = null

        fun getInstance(databaseDAO: DatabaseDAO) =
            instance ?: synchronized(this) {
                instance ?: BicyclesRepository(databaseDAO).also { instance = it }
            }
    }
}