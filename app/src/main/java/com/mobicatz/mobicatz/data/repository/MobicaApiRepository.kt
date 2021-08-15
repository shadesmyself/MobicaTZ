package com.mobicatz.mobicatz.data.repository

import com.mobicatz.mobicatz.data.dto.CardsData
import retrofit2.Response

interface MobicaApiRepository {
    suspend fun getCards() : Response<CardsData>
}