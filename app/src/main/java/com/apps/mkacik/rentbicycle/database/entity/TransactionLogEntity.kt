package com.apps.mkacik.rentbicycle.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "TRANSACTION_LOG")
class TransactionLogEntity(
    @PrimaryKey
    var id: Int,
    @ColumnInfo(name = "DIFFERENCE")
    var differenc: String,
    @ColumnInfo(name = "WALLET_CASH")
    var walletCash: Float

)