package com.apps.mkacik.rentbicycle.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.apps.mkacik.rentbicycle.data.database.entity.BicycleEntity
import com.apps.mkacik.rentbicycle.data.database.entity.RentEntity
import com.apps.mkacik.rentbicycle.data.database.entity.TransactionLogEntity


@Dao
interface DatabaseDAO {

    @Insert
    fun saveBicycle(bicycle: BicycleEntity)

    @Insert
    fun saveRent(rent: RentEntity)

    @Query("select * from BICYCLES")
    fun getBicycles(): LiveData<List<BicycleEntity>>

    @Query("select * from RENTS")
    fun getRents(): LiveData<List<RentEntity>>

    @Query("select * from TRANSACTION_LOG")
    fun getTransactionLog(): List<TransactionLogEntity>

}