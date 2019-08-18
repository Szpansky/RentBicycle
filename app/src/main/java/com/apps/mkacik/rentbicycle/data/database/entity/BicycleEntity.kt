package com.apps.mkacik.rentbicycle.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.apps.mkacik.rentbicycle.R
import java.io.Serializable


@Entity(tableName = "BICYCLES")
data class BicycleEntity(

    @ColumnInfo(name = "STATUS")
    var availability: Boolean,
    @ColumnInfo(name = "PRICE")
    var price: Float,
    @ColumnInfo(name = "COLOR")
    var color: String,
    @ColumnInfo(name = "BRAND")
    var brand: String,
    @ColumnInfo(name = "BICYCLE_ID")
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

) : Serializable {
    companion object {
        const val BICYCLE_AVAILABILITY_FALSE: Int = R.string.occupied
        const val BICYCLE_AVAILABILITY_TRUE: Int = R.string.available
    }
}
