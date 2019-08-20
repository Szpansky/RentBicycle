package com.apps.mkacik.rentbicycle.utilities

import com.apps.mkacik.rentbicycle.data.BicyclesRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(dependencies = [], modules = [RoomModule::class])
interface AppComponent {

    fun providesBicycleRepository(): BicyclesRepository

}