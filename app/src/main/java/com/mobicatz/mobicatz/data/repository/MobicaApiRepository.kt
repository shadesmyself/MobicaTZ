package com.mobicatz.mobicatz.data.repository

import com.mobicatz.mobicatz.data.dto.MobicaTzRecyclerViewData
import retrofit2.Call
import retrofit2.Response

interface MobicaApiRepository {
    suspend fun getRequest() : Response<MobicaTzRecyclerViewData>
}