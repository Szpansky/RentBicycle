package com.apps.mkacik.rentbicycle.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey


@Entity(
    tableName = "RENTS",
    foreignKeys = [ForeignKey(
        entity = BicycleEntity::class,
        parentColumns = ["id"],
        childColumns = ["RENT_BIKE_ID"],
        onDelete = CASCADE
    )]
)

data class RentEntity(

    @ColumnInfo(name = "RENT_BIKE_ID", index = true)
    var idBike: Int,
    @ColumnInfo(name = "RENT_BIKE_DATE_START", defaultValue = "00-00-00 00:00:00")
    var date: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}