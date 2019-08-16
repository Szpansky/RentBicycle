package com.apps.mkacik.rentbicycle.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.apps.mkacik.rentbicycle.data.database.entity.BicycleEntity
import com.apps.mkacik.rentbicycle.data.database.entity.RentEntity
import com.apps.mkacik.rentbicycle.data.database.entity.TransactionLogEntity

@Database(
    entities = [(BicycleEntity::class), (RentEntity::class), (TransactionLogEntity::class)],
    version = 1
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun rentBicycleDAO(): DatabaseDAO

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()
        const val NAME = "RentBicycleDatabase.db"

        operator fun invoke(context: Context) =
            instance
                ?: synchronized(LOCK) {
                    instance
                        ?: buildDatabase(context).also { instance = it }
                }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            NAME
        ).allowMainThreadQueries()
            .build()
    }
}