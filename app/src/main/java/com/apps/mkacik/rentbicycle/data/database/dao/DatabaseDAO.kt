package com.apps.mkacik.rentbicycle.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.apps.mkacik.rentbicycle.data.database.dao.BicycleDao
import com.apps.mkacik.rentbicycle.data.database.dao.RentDao
import com.apps.mkacik.rentbicycle.data.database.dao.TransactionLogDao


@Dao
interface DatabaseDAO : RentDao, BicycleDao, TransactionLogDao {

    @Query("DELETE FROM BICYCLES")
    fun deleteTableBicycles()

    @Query("DELETE FROM TRANSACTION_LOG")
    fun deleteTableTransactionLogs()

    @Query("DELETE FROM RENTS")
    fun deleteTableRents()

}