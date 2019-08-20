package com.apps.mkacik.rentbicycle.data.database.model

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.apps.mkacik.rentbicycle.data.database.entity.RentEntity

interface RentDao {

    @Query("select * from RENTS inner join BICYCLES on RENTS.RENT_BICYCLE_ID = BICYCLES.BICYCLE_ID")
    fun getRentsWithBicycle(): LiveData<List<Rent>>

    @Delete
    fun deleteRent(rentEntity: RentEntity)

    @Insert
    fun saveRent(rent: RentEntity)
}