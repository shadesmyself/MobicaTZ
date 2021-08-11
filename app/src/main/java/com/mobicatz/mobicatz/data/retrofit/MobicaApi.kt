package com.mobicatz.mobicatz.data.retrofit

import com.mobicatz.mobicatz.data.dto.MobicaTzRecyclerViewData
import retrofit2.Response
import retrofit2.http.GET

interface MobicaApi {
    @GET("/test/home")
    suspend fun getMobicaData(
    ): Response<MobicaTzRecyclerViewData>
}