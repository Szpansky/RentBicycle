package com.apps.mkacik.rentbicycle.data

import com.apps.mkacik.rentbicycle.data.database.DatabaseDAO
import com.apps.mkacik.rentbicycle.data.database.entity.BicycleEntity

class Repository private constructor(private val databaseDAO: DatabaseDAO) {

    fun getBicycles() = databaseDAO.getBicycles()

    fun addBicycle(bicycleEntity: BicycleEntity) = databaseDAO.saveBicycle(bicycleEntity)

    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(databaseDAO: DatabaseDAO) =
            instance ?: synchronized(this) {
                instance ?: Repository(databaseDAO).also { instance = it }
            }
    }
}