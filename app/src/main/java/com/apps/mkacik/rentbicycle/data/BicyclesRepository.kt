package com.apps.mkacik.rentbicycle.data

import com.apps.mkacik.rentbicycle.data.database.DatabaseDAO
import com.apps.mkacik.rentbicycle.data.database.entity.BicycleEntity
import com.apps.mkacik.rentbicycle.data.database.entity.RentEntity

class BicyclesRepository private constructor(private val databaseDAO: DatabaseDAO) : BicycleLoadingProvider {

    override fun getRentBicycles(rentBicyclesCallBack: BicycleLoadingProvider.GetRentBicyclesCallBack) {
        rentBicyclesCallBack.onSuccess(databaseDAO.getRents())
    }

    override fun rentBicycle(bicycle: BicycleEntity, rentCallBack: BicycleLoadingProvider.RentCallBack) {
        if (bicycle.status) {
            rentCallBack.onFail(Throwable("Bike already occupied"))
        } else {
            databaseDAO.saveRent(RentEntity(bicycle.id, System.currentTimeMillis().toString()))
            rentCallBack.onSuccess()
        }
    }

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