package com.apps.mkacik.rentbicycle.data

import com.apps.mkacik.rentbicycle.data.database.DatabaseDAO
import com.apps.mkacik.rentbicycle.data.database.entity.BicycleEntity
import com.apps.mkacik.rentbicycle.data.database.entity.Rent
import com.apps.mkacik.rentbicycle.data.database.entity.RentEntity
import com.apps.mkacik.rentbicycle.utilities.SimpleFunction

class BicyclesRepository private constructor(private val databaseDAO: DatabaseDAO) : BicycleLoadingProvider {

    override fun endRent(rent: Rent, endRentCallBack: BicycleLoadingProvider.EndRentCallBack) {
        if (!rent.availability) {
            databaseDAO.deleteRent(RentEntity(rent.bicycleId, rent.dateStart, rent.id))

            rent.availability = !rent.availability

            val bicycle = BicycleEntity(rent.availability, rent.price, rent.color, rent.brand, rent.bicycleId)
            databaseDAO.updateBicycle(bicycle)

            endRentCallBack.onSuccess()
        } else {
            endRentCallBack.onFail(Throwable("Bike already available"))
        }
    }

    override fun editBicycle(bicycle: BicycleEntity, editCallBack: BicycleLoadingProvider.EditCallBack) {
        databaseDAO.updateBicycle(bicycle)
        editCallBack.onSuccess()
    }

    fun deleteData() {
        databaseDAO.deleteTableBicycles()
        databaseDAO.deleteTableRents()
        databaseDAO.deleteTableTransactionLogs()
    }

    override fun addBicycles(bicycles: List<BicycleEntity>, addListCallBack: BicycleLoadingProvider.AddListCallBack) {
        databaseDAO.saveBicycles(bicycles)
        addListCallBack.onSuccess()
    }

    override fun getRentBicycles(rentBicyclesCallBack: BicycleLoadingProvider.GetRentBicyclesCallBack) {
        rentBicyclesCallBack.onSuccess(databaseDAO.getRentsWithBicycle())
    }

    override fun rentBicycle(bicycle: BicycleEntity, rentCallBack: BicycleLoadingProvider.RentCallBack) {
        if (bicycle.availability) {
            databaseDAO.saveRent(RentEntity(bicycle.id, SimpleFunction.getCurrentDate()))
            bicycle.availability = !bicycle.availability
            databaseDAO.updateBicycle(bicycle)
            rentCallBack.onSuccess()
        } else {
            rentCallBack.onFail(Throwable("Bike already occupied"))
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