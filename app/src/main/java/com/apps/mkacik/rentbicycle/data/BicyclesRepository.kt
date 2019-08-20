package com.apps.mkacik.rentbicycle.data

import androidx.lifecycle.LiveData
import com.apps.mkacik.rentbicycle.data.database.DatabaseDAO
import com.apps.mkacik.rentbicycle.data.database.entity.BicycleEntity
import com.apps.mkacik.rentbicycle.data.database.entity.Rent
import com.apps.mkacik.rentbicycle.data.database.entity.RentEntity
import com.apps.mkacik.rentbicycle.utilities.SimpleFunction
import javax.inject.Inject

class BicyclesRepository @Inject constructor(private val databaseDao: DatabaseDAO) : BicycleLoadingProvider {

    override fun endRent(rent: Rent, endRentCallBack: BicycleLoadingProvider.EndRentCallBack) {
        if (!rent.availability) {
            databaseDao.deleteRent(RentEntity(rent.bicycleId, rent.dateStart, rent.id))

            rent.availability = !rent.availability

            val bicycle = BicycleEntity(rent.availability, rent.price, rent.color, rent.brand, rent.bicycleId)
            databaseDao.updateBicycle(bicycle)

            endRentCallBack.onSuccess()
        } else {
            endRentCallBack.onFail(Throwable("Bike already available"))
        }
    }

    override fun editBicycle(bicycle: BicycleEntity, editCallBack: BicycleLoadingProvider.EditCallBack) {
        databaseDao.updateBicycle(bicycle)
        editCallBack.onSuccess()
    }

    override fun deleteData() {
        databaseDao.deleteTableBicycles()
        databaseDao.deleteTableRents()
        databaseDao.deleteTableTransactionLogs()
    }

    override fun addBicycles(bicycles: List<BicycleEntity>, addListCallBack: BicycleLoadingProvider.AddListCallBack) {
        databaseDao.saveBicycles(bicycles)
        addListCallBack.onSuccess()
    }

    override fun getRentBicycles(rentBicyclesCallBack: BicycleLoadingProvider.GetRentBicyclesCallBack) {
        rentBicyclesCallBack.onSuccess(databaseDao.getRentsWithBicycle())
    }

    override fun rentBicycle(bicycle: BicycleEntity, rentCallBack: BicycleLoadingProvider.RentCallBack) {
        if (bicycle.availability) {
            databaseDao.saveRent(RentEntity(bicycle.id, SimpleFunction.getCurrentDate()))
            bicycle.availability = !bicycle.availability
            databaseDao.updateBicycle(bicycle)
            rentCallBack.onSuccess()
        } else {
            rentCallBack.onFail(Throwable("Bike already occupied"))
        }
    }

    override fun addBicycle(bicycle: BicycleEntity, addCallBack: BicycleLoadingProvider.AddCallBack) {
        databaseDao.saveBicycle(bicycle)
        addCallBack.onSuccess()
    }

    override fun getBicycles(getCallBack: BicycleLoadingProvider.GetCallBack) {
        getCallBack.onSuccess(databaseDao.getBicycles())
    }

    override fun getBicycles(): LiveData<List<BicycleEntity>> {
        return databaseDao.getBicycles()
    }
}