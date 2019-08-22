package com.apps.mkacik.rentbicycle.data.database.repository

import com.apps.mkacik.rentbicycle.data.database.dao.DatabaseDAO
import javax.inject.Inject

class TransactionLogRepository  @Inject constructor(private val databaseDao: DatabaseDAO)