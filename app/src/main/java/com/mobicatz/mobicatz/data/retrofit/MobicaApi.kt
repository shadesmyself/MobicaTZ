package com.mobicatz.mobicatz.data.retrofit

import com.mobicatz.mobicatz.data.dto.ResponseRecyclerViewData
import retrofit2.Call
import retrofit2.http.GET

interface MobicaApi {
    @GET("/test/home")
    suspend fun getMobicaData(
    ): Call<ResponseRecyclerViewData>
}