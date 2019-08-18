package com.apps.mkacik.rentbicycle.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(
    tableName = "RENTS",
    foreignKeys = [ForeignKey(
        entity = BicycleEntity::class,
        parentColumns = ["BICYCLE_ID"],
        childColumns = ["RENT_BICYCLE_ID"],
        onDelete = CASCADE
    )]
)

data class RentEntity(

    @ColumnInfo(name = "RENT_BICYCLE_ID", index = true)
    var rentBicycleId: Int,
    @ColumnInfo(name = "RENT_BICYCLE_DATE_START", defaultValue = "00-00-00 00:00:00")
    var dateStart: String
) : Serializable {
    @ColumnInfo(name = "RENT_ID")
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0


}