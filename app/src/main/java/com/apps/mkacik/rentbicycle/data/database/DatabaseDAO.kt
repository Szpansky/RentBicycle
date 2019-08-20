package com.apps.mkacik.rentbicycle.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.apps.mkacik.rentbicycle.data.database.entity.BicycleEntity
import com.apps.mkacik.rentbicycle.data.database.entity.Rent
import com.apps.mkacik.rentbicycle.data.database.entity.RentEntity
import com.apps.mkacik.rentbicycle.data.database.entity.TransactionLogEntity


@Dao
interface DatabaseDAO {

    @Update
    fun updateBicycle(bicycle: BicycleEntity)

    @Query("DELETE FROM BICYCLES")
    fun deleteTableBicycles()

    @Query("DELETE FROM RENTS")
    fun deleteTableRents()

    @Query("DELETE FROM TRANSACTION_LOG")
    fun deleteTableTransactionLogs()

    @Insert
    fun saveBicycles(bicycles: List<BicycleEntity>)

    @Insert
    fun saveBicycle(bicycle: BicycleEntity)

    @Insert
    fun saveRent(rent: RentEntity)

    @Query("select * from BICYCLES ")
    fun getBicycles(): LiveData<List<BicycleEntity>>

    @Query("select * from RENTS inner join BICYCLES on RENTS.RENT_BICYCLE_ID = BICYCLES.BICYCLE_ID")
    fun getRentsWithBicycle(): LiveData<List<Rent>>

    @Query("select * from TRANSACTION_LOG")
    fun getTransactionLog(): List<TransactionLogEntity>

    @Delete
    fun deleteRent(rentEntity: RentEntity)

}