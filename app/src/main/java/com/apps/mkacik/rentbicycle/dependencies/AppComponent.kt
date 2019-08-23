package com.apps.mkacik.rentbicycle.dependencies

import android.app.Application
import com.apps.mkacik.rentbicycle.activities.MainActivity
import com.apps.mkacik.rentbicycle.activities.RentedBicycleActivity
import com.apps.mkacik.rentbicycle.data.database.repository.BicyclesRepository
import com.apps.mkacik.rentbicycle.fragments.BicycleListFragment
import com.apps.mkacik.rentbicycle.fragments.RentedListFragment
import com.apps.mkacik.rentbicycle.viewModels.ViewModelFactory
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(dependencies = [], modules = [RoomModule::class, AppModule::class])
interface AppComponent {

    fun providesBicycleRepository(): BicyclesRepository
    fun providesVMFactory(): ViewModelFactory.Factory
    fun providesApplication(): Application


    fun inject(mainActivity: MainActivity)
    fun inject(rentedBicycleActivity: RentedBicycleActivity)
    fun inject(bicycleListFragment: BicycleListFragment)
    fun inject(rentedListFragment: RentedListFragment)

}