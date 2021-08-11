package com.mobicatz.mobicatz.data.remote

import com.mobicatz.mobicatz.data.dto.MobicaTzRecyclerViewData
import retrofit2.Response

interface NetworkDatabaseDataSource {

    suspend fun getMobicaApi(): Response<MobicaTzRecyclerViewData>

}