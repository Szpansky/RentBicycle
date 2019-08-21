package com.apps.mkacik.rentbicycle.data

import com.apps.mkacik.rentbicycle.data.database.providers.BicycleProvider
import com.apps.mkacik.rentbicycle.data.database.providers.RentProvider
import com.apps.mkacik.rentbicycle.data.database.providers.TransactionLogProvider

interface LoadingProvider : BicycleProvider,
    RentProvider,
    TransactionLogProvider {
    fun deleteData()
}