package com.mobicatz.mobicatz.data.remote

import com.mobicatz.mobicatz.data.dto.ResponseRecyclerViewData
import retrofit2.Call

interface NetworkDatabaseDataSource {

    suspend fun getMobicaApi(): Call<ResponseRecyclerViewData>

}