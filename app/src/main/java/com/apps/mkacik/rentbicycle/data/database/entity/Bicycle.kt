package com.apps.mkacik.rentbicycle.data.database.entity

import androidx.room.ColumnInfo
import java.io.Serializable

data class Bicycle(

    @ColumnInfo(name = "STATUS")
    var availability: Boolean,
    @ColumnInfo(name = "PRICE")
    var price: Float,
    @ColumnInfo(name = "COLOR")
    var color: String,
    @ColumnInfo(name = "BRAND")
    var brand: String


) : Serializable
