package com.apps.mkacik.rentbicycle.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.apps.mkacik.rentbicycle.database.entity.BikeEntity
import com.apps.mkacik.rentbicycle.database.entity.RentEntity
import com.apps.mkacik.rentbicycle.database.entity.TransactionLogEntity


@Dao
interface DatabaseDAO {

    @Insert
    fun saveBike(bike: BikeEntity)

    @Insert
    fun saveRent(rent: RentEntity)

    @Query("select * from BIKES")
    fun getBicycles(): List<BikeEntity>

    @Query("select * from RENTS")
    fun getRents(): List<RentEntity>

    @Query("select * from TRANSACTION_LOG")
    fun getTranactionLog(): List<TransactionLogEntity>

}