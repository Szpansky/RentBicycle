package com.apps.mkacik.rentbicycle.data.database.repository

import com.apps.mkacik.rentbicycle.data.database.dao.DatabaseDAO
import com.apps.mkacik.rentbicycle.data.database.entity.BicycleEntity
import com.apps.mkacik.rentbicycle.data.database.model.Rent
import com.apps.mkacik.rentbicycle.data.database.providers.RentProvider
import javax.inject.Inject

open class RentRepository  @Inject constructor(private val databaseDao: DatabaseDAO) : RentProvider {

    override fun endRent(rent: Rent, endRentCallBack: RentProvider.EndRentCallBack) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun rentBicycle(bicycle: BicycleEntity, rentCallBack: RentProvider.RentCallBack) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRentBicycles(rentBicyclesCallBack: RentProvider.GetRentBicyclesCallBack) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
