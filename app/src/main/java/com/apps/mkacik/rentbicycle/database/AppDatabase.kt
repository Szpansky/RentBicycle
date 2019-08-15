package com.apps.mkacik.rentbicycle.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.apps.mkacik.rentbicycle.database.entity.BikeEntity
import com.apps.mkacik.rentbicycle.database.entity.RentEntity
import com.apps.mkacik.rentbicycle.database.entity.TransactionLogEntity

@Database(entities = [(BikeEntity::class), (RentEntity::class), (TransactionLogEntity::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun rentBicycleDAO(): DatabaseDAO
}