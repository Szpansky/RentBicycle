package com.apps.mkacik.rentbicycle.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "BICYCLES")
data class BicycleEntity(

    @ColumnInfo(name = "STATUS")
    var status: Boolean,
    @ColumnInfo(name = "PRICE")
    var price: Float,
    @ColumnInfo(name = "COLOR")
    var color: String,
    @ColumnInfo(name = "BRAND")
    var brand: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}