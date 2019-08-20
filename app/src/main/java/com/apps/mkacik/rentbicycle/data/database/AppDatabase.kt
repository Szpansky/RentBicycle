package com.apps.mkacik.rentbicycle.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.apps.mkacik.rentbicycle.data.database.entity.BicycleEntity
import com.apps.mkacik.rentbicycle.data.database.entity.RentEntity
import com.apps.mkacik.rentbicycle.data.database.entity.TransactionLogEntity

@Database(
    entities = [(BicycleEntity::class), (RentEntity::class), (TransactionLogEntity::class)],
    version = 1
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun databaseDao(): DatabaseDAO

}