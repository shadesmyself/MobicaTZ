package com.mobicatz.mobicatz.data.remote

import com.mobicatz.mobicatz.data.dto.CardsData
import retrofit2.Response

interface NetworkDatabaseDataSource {

    suspend fun getCards(): Response<CardsData>

}