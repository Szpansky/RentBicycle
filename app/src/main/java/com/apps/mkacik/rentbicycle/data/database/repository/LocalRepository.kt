package com.apps.mkacik.rentbicycle.data.database.repository

import com.apps.mkacik.rentbicycle.data.database.dao.DatabaseDAO
import com.apps.mkacik.rentbicycle.data.database.entity.BicycleEntity
import com.apps.mkacik.rentbicycle.data.database.providers.BicycleProvider
import javax.inject.Inject

/**
 * TMP
 */
class LocalRepository @Inject constructor(val databaseDao: DatabaseDAO) {


lateinit var bicyclesRepository : BicyclesRepository
    lateinit var rentRepository: RentRepository
    lateinit var transactionLogRepository: TransactionLogRepository

    fun add(entityType: EntityType, bicycleEntity: BicycleEntity) = when (entityType){
        EntityType.BICYCLE ->{


            databaseDao.saveBicycle(bicycleEntity)

            bicyclesRepository.addBicycle(bicycleEntity,object : BicycleProvider.AddCallBack{
                override fun onSuccess() {

                }

                override fun onFail(throwable: Throwable) {

                }
            })
        }
        EntityType.RENT ->{

        }
        EntityType.TRANSACTION ->{

        }

        else -> {

        }
    }





enum class EntityType{
    BICYCLE,RENT,TRANSACTION
}


}