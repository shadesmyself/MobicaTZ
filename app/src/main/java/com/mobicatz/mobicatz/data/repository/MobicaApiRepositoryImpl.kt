package com.mobicatz.mobicatz.data.repository

import com.mobicatz.mobicatz.data.dto.ResponseRecyclerViewData
import com.mobicatz.mobicatz.data.remote.NetworkDatabaseDataSource
import com.mobicatz.mobicatz.data.retrofit.MobicaApi
import retrofit2.Call

class MobicaApiRepositoryImpl(private val networkDatabaseDataSource: NetworkDatabaseDataSource): MobicaApiRepository {

    override suspend fun getRequest() : Call<ResponseRecyclerViewData> = networkDatabaseDataSource.getMobicaApi()

}