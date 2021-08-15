package com.mobicatz.mobicatz.data.retrofit

import com.mobicatz.mobicatz.data.dto.CardsData
import retrofit2.Response
import retrofit2.http.GET

interface MobicaApi {
    @GET("/test/home")
    suspend fun getCardsMobicaApi(
    ): Response<CardsData>
}