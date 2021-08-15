package com.mobicatz.mobicatz.data.repository

import com.mobicatz.mobicatz.data.dto.CardsData
import com.mobicatz.mobicatz.data.remote.NetworkDatabaseDataSource
import retrofit2.Response

class MobicaApiRepositoryImpl(private val networkDatabaseDataSource: NetworkDatabaseDataSource): MobicaApiRepository {

    override suspend fun getCards() : Response<CardsData> = networkDatabaseDataSource.getCards()

}