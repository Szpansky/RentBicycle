package com.apps.mkacik.rentbicycle.data.database.entity

import androidx.room.Query

interface TransactionLogDao {



    @Query("select * from TRANSACTION_LOG")
    fun getTransactionLog(): List<TransactionLogEntity>
}