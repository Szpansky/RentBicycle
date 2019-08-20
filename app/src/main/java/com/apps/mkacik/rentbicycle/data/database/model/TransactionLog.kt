package com.apps.mkacik.rentbicycle.data.database.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import java.io.Serializable

class TransactionLog constructor(
    @ColumnInfo(name = "DIFFERENCE")
    var difference: Float,

    @ColumnInfo(name = "WALLET_CASH")
    var walletCash: Float,

    @PrimaryKey
    var id: Int = 0
) : Serializable