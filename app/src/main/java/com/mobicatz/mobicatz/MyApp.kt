package com.mobicatz.mobicatz

import android.app.Application
import androidx.annotation.Keep
import com.google.gson.GsonBuilder
import com.mobicatz.mobicatz.di.components.AppComponent
import com.mobicatz.mobicatz.di.components.DaggerAppComponent
import com.mobicatz.mobicatz.di.module.ContextModule
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
       initializeDagger()
    }
    private val gson = GsonBuilder()
        .setLenient()
        .create()

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .client(getOkHttp())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    private fun getOkHttp(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .followRedirects(false)
            .followSslRedirects(false)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    private fun initializeDagger() {
        appComponent = DaggerAppComponent.builder()
            .contextModule(ContextModule(this))
            .build()
    }

    @Keep
    companion object {
        lateinit var appComponent: AppComponent
        private const val BASE_URL = "https://private-8ce77c-tmobiletest.apiary-mock.com"
    }
}