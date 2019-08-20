package com.apps.mkacik.rentbicycle.data.database

import androidx.room.Dao
import androidx.room.Query
import com.apps.mkacik.rentbicycle.data.database.model.BicycleDao
import com.apps.mkacik.rentbicycle.data.database.model.RentDao
import com.apps.mkacik.rentbicycle.data.database.model.TransactionLogDao


@Dao
interface DatabaseDAO : RentDao, BicycleDao, TransactionLogDao {

    @Query("DELETE FROM BICYCLES")
    fun deleteTableBicycles()

    @Query("DELETE FROM TRANSACTION_LOG")
    fun deleteTableTransactionLogs()

    @Query("DELETE FROM RENTS")
    fun deleteTableRents()

}