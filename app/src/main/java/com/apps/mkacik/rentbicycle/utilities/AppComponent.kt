package com.apps.mkacik.rentbicycle.utilities

import com.apps.mkacik.rentbicycle.activities.MainActivity
import com.apps.mkacik.rentbicycle.activities.RentedBicycleActivity
import com.apps.mkacik.rentbicycle.data.BicyclesRepository
import com.apps.mkacik.rentbicycle.fragments.BaseListFragment
import com.apps.mkacik.rentbicycle.fragments.BicycleListFragment
import com.apps.mkacik.rentbicycle.fragments.RentedListFragment
import com.apps.mkacik.rentbicycle.viewModels.ViewModelFactory
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(dependencies = [], modules = [RoomModule::class, AppModule::class])
interface AppComponent {


    fun providesBicycleRepository(): BicyclesRepository
    fun providesVMBicycle(): ViewModelFactory.Bicycles
    fun providesVMBRentedBicycles(): ViewModelFactory.RentedBicycles
    fun providesVMRentedInfo(): ViewModelFactory.RentedInfo


    fun inject(mainActivity: MainActivity)
    fun inject(rentedBicycleActivity: RentedBicycleActivity)
    fun inject(bicycleListFragment: BicycleListFragment)
    fun inject(rentedListFragment: RentedListFragment)
    fun inject(baseListFragment: BaseListFragment)



}