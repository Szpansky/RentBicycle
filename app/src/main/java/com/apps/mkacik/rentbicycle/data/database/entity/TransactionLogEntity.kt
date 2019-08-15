package com.apps.mkacik.rentbicycle.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "TRANSACTION_LOG")
class TransactionLogEntity(

    @ColumnInfo(name = "DIFFERENCE")
    var differenc: Float,
    @ColumnInfo(name = "WALLET_CASH")
    var walletCash: Float

) {
    @PrimaryKey
    var id: Int = 0
}