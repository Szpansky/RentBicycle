package com.apps.mkacik.rentbicycle.data.database.dao

import androidx.room.Query
import com.apps.mkacik.rentbicycle.data.database.entity.TransactionLogEntity

interface TransactionLogDao {

    @Query("select * from TRANSACTION_LOG")
    fun getTransactionLog(): List<TransactionLogEntity>
}