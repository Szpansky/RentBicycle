package com.apps.mkacik.rentbicycle.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "BIKES")
class BikeEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "STATUS")
    var status: Boolean,
    @ColumnInfo(name = "PRICE")
    var price: Double,
    @ColumnInfo(name = "COLOR")
    var color: String,
    @ColumnInfo(name = "BRAND")
    var brand: String
)