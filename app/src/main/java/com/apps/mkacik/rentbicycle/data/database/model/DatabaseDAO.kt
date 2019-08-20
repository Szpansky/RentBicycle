package com.apps.mkacik.rentbicycle.data.database.model

import androidx.room.Dao
import androidx.room.Query


@Dao
interface DatabaseDAO : RentDao, BicycleDao, TransactionLogDao {

    @Query("DELETE FROM BICYCLES")
    fun deleteTableBicycles()

    @Query("DELETE FROM TRANSACTION_LOG")
    fun deleteTableTransactionLogs()

    @Query("DELETE FROM RENTS")
    fun deleteTableRents()

}