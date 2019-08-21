package com.apps.mkacik.rentbicycle.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.apps.mkacik.rentbicycle.data.database.entity.*
import com.apps.mkacik.rentbicycle.data.database.model.Rent


@Dao
interface DatabaseDAO : RentDao, BicycleDao, TransactionLogDao {

    @Query("DELETE FROM BICYCLES")
    fun deleteTableBicycles()

    @Query("DELETE FROM TRANSACTION_LOG")
    fun deleteTableTransactionLogs()

    @Query("DELETE FROM RENTS")
    fun deleteTableRents()

}