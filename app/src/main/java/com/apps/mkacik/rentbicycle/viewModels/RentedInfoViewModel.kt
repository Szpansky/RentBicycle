package com.apps.mkacik.rentbicycle.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.apps.mkacik.rentbicycle.data.BicycleRepo
import com.apps.mkacik.rentbicycle.data.database.model.Rent
import com.apps.mkacik.rentbicycle.utilities.DaggerAppComponent
import com.apps.mkacik.rentbicycle.utilities.RoomModule
import javax.inject.Inject

class RentedInfoViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var bicycleRepo: BicycleRepo

    init {
        DaggerAppComponent.builder()
            .roomModule(RoomModule(application))
            .build()
            .inject(this)
    }


    fun endRent(rent: Rent, callBack: BicycleRepo.EndRentCallBack) {
        bicycleRepo.endRent(rent, callBack)
    }
}