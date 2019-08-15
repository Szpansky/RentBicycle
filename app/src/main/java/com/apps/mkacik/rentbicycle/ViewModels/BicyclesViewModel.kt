package com.apps.mkacik.rentbicycle.ViewModels

import androidx.lifecycle.ViewModel
import com.apps.mkacik.rentbicycle.data.Repository
import com.apps.mkacik.rentbicycle.data.database.entity.BicycleEntity

class BicyclesViewModel(private val repository: Repository) : ViewModel() {

    // private val bicyclesList = mutableListOf<Bicycle>()
    // private val bicycles = MutableLiveData<List<Bicycle>>()


    init {
        //bicycles.value = bicyclesList
    }

    fun addBicycle(bicycle: BicycleEntity) {
        repository.addBicycle(bicycle)
    }

    fun getBicycles() = repository.getBicycles() // as LiveData<List<Bicycle>>
}