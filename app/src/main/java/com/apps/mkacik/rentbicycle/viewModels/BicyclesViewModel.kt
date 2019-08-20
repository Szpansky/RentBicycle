package com.apps.mkacik.rentbicycle.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.apps.mkacik.rentbicycle.data.BicycleRepo
import com.apps.mkacik.rentbicycle.data.database.entity.BicycleEntity
import com.apps.mkacik.rentbicycle.utilities.AppModule
import com.apps.mkacik.rentbicycle.utilities.DaggerAppComponent
import com.apps.mkacik.rentbicycle.utilities.RoomModule
import javax.inject.Inject


class BicyclesViewModel(application: Application) : AndroidViewModel(application) {

/*
    lateinit var bicyclesObservable: LiveData<List<BicycleEntity>> =
        Transformations.map(bicycleRepo.getBicycles()){data->

        }*/

    fun getBicycles(): LiveData<List<BicycleEntity>> {
        return bicycleRepo.getBicycles()
    }


    @Inject
    lateinit var bicycleRepo: BicycleRepo

    init {

        DaggerAppComponent.builder()
            .appModule(AppModule(getApplication()))
            .roomModule(RoomModule(getApplication()))
            .build()
            .inject(this)


    }


    fun getBicycles(getCallBack: BicycleRepo.GetCallBack) {
        bicycleRepo.getBicycles(getCallBack)
    }


    fun rentBicycle(bicycle: BicycleEntity, rentCallBack: BicycleRepo.RentCallBack) {
        bicycleRepo.rentBicycle(bicycle, rentCallBack)
    }
}