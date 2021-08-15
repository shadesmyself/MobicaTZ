package com.mobicatz.mobicatz.data.remote

import android.content.Context
import com.mobicatz.mobicatz.MyApp
import com.mobicatz.mobicatz.data.dto.CardsData
import com.mobicatz.mobicatz.data.retrofit.MobicaApi
import retrofit2.Response

class NetworkDatabaseDataSourceImpl(private val context: Context) : NetworkDatabaseDataSource {

    override suspend fun getCards(): Response<CardsData> {
        return (context as MyApp).getRetrofit().create(MobicaApi::class.java).getCardsMobicaApi()
    }
}