package com.apps.mkacik.rentbicycle.data

import androidx.lifecycle.LiveData
import com.apps.mkacik.rentbicycle.data.database.entity.BicycleEntity
import com.apps.mkacik.rentbicycle.data.database.model.Rent
import com.apps.mkacik.rentbicycle.data.database.providers.BicycleProvider
import com.apps.mkacik.rentbicycle.data.database.providers.RentProvider

class ControlLoadingProvider : LoadingProvider {
    override fun deleteData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun editBicycle(bicycle: BicycleEntity, editCallBack: BicycleProvider.EditCallBack) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addBicycles(bicycles: List<BicycleEntity>, addListCallBack: BicycleProvider.AddListCallBack) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addBicycle(bicycle: BicycleEntity, addCallBack: BicycleProvider.AddCallBack) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBicycles(getCallBack: BicycleProvider.GetCallBack) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBicycles(): LiveData<List<BicycleEntity>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

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