package com.mobicatz.mobicatz.data.repository

import com.mobicatz.mobicatz.data.dto.ResponseRecyclerViewData
import retrofit2.Call

interface MobicaApiRepository {
    suspend fun getRequest() : Call<ResponseRecyclerViewData>
}