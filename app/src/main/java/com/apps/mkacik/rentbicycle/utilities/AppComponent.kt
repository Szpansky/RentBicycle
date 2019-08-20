package com.apps.mkacik.rentbicycle.utilities

import android.app.Application
import com.apps.mkacik.rentbicycle.activities.MainActivity
import com.apps.mkacik.rentbicycle.data.BicycleRepo
import com.apps.mkacik.rentbicycle.data.database.model.DatabaseDAO
import com.apps.mkacik.rentbicycle.data.database.repository.AppDatabase
import com.apps.mkacik.rentbicycle.viewModels.BicyclesViewModel
import com.apps.mkacik.rentbicycle.viewModels.RentedInfoViewModel
import com.apps.mkacik.rentbicycle.viewModels.RentedViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(dependencies = [], modules = [RoomModule::class, AppModule::class])
interface AppComponent {

    fun inject(baseViewModel: BicyclesViewModel)

    fun inject(rentedViewModel: RentedViewModel)

    fun inject(rentedInfoViewModel: RentedInfoViewModel)

    fun inject(mainActivity: MainActivity)

    fun databaseDao(): DatabaseDAO

    fun appDatabase(): AppDatabase

    fun bicycleRepo(): BicycleRepo

    fun application(): Application

}