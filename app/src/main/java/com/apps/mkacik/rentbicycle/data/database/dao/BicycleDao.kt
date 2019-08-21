package com.apps.mkacik.rentbicycle.data.database.entity

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface BicycleDao {

    @Update
    fun updateBicycle(bicycle: BicycleEntity)

    @Insert
    fun saveBicycles(bicycles: List<BicycleEntity>)

    @Insert
    fun saveBicycle(bicycle: BicycleEntity)

    @Query("select * from BICYCLES ")
    fun getBicycles(): LiveData<List<BicycleEntity>>
}