package com.apps.mkacik.rentbicycle.data.database.model

import androidx.room.ColumnInfo
import java.io.Serializable

data class Rent constructor(
    @ColumnInfo(name = "STATUS")
    var availability: Boolean = false,

    @ColumnInfo(name = "PRICE")
    var price: Float = 0.0f,

    @ColumnInfo(name = "COLOR")
    var color: String,

    @ColumnInfo(name = "BRAND")
    var brand: String,

    @ColumnInfo(name = "BICYCLE_ID")
    var bicycleId: Int = 0,

    @ColumnInfo(name = "RENT_BICYCLE_DATE_START")
    var dateStart: String,

    @ColumnInfo(name = "RENT_ID")
    var id: Int = 0
) : Serializable



