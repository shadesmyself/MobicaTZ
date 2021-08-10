package com.mobicatz.mobicatz.data.remote

import android.content.Context
import com.mobicatz.mobicatz.MyApp
import com.mobicatz.mobicatz.data.dto.ResponseRecyclerViewData
import com.mobicatz.mobicatz.data.retrofit.MobicaApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call

class NetworkDatabaseDataSourceImpl(private val context: Context) : NetworkDatabaseDataSource {

    override suspend fun getMobicaApi(): Call<ResponseRecyclerViewData> {
        return withContext(Dispatchers.IO) {
            (context as MyApp).getRetrofit().create(MobicaApi::class.java).getMobicaData()
        }
    }
}