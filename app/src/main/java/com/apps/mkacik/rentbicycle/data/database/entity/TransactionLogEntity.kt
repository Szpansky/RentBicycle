package com.apps.mkacik.rentbicycle.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "TRANSACTION_LOG")
data class TransactionLogEntity(

    @ColumnInfo(name = "DIFFERENCE")
    var difference: Float,
    @ColumnInfo(name = "WALLET_CASH")
    var walletCash: Float

) : Serializable {
    @PrimaryKey
    var id: Int = 0
}