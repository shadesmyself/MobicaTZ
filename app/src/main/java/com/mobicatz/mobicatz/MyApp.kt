package com.mobicatz.mobicatz

import android.app.Application
import androidx.annotation.Keep
import com.google.gson.*
import com.mobicatz.mobicatz.data.dto.Card
import com.mobicatz.mobicatz.data.dto.Image
import com.mobicatz.mobicatz.di.components.AppComponent
import com.mobicatz.mobicatz.di.components.DaggerAppComponent
import com.mobicatz.mobicatz.di.module.ContextModule
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import java.util.concurrent.TimeUnit
import com.mobicatz.mobicatz.data.dto.Text
import java.io.IOException


class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    private val gson = GsonBuilder()
        .setLenient()
        .registerTypeAdapter(Card::class.java,CardDeserializer(Gson()))
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

    class CardDeserializer(private val gson: Gson) : JsonDeserializer<Card> {
        override fun deserialize(
            json: JsonElement?,
            typeOfT: Type?,
            context: JsonDeserializationContext?
        ): Card {
            val jsonObject = json!!.asJsonObject

            return when (jsonObject.get(CARD_TYPE).asString) {
                CARD_TYPE_IMAGE_TITLE_DESCRIPTION -> getImageTitleDescriptionCard(jsonObject)
                CARD_TYPE_TITLE_DESCRIPTION -> getTitleCard(jsonObject)
                CARD_TYPE_TEXT -> getTextCard(jsonObject.get(CARD_KEY).asJsonObject)
                else -> throw IOException()
            }
        }

        private fun getTextCard(jsonObject: JsonObject): Card.TextCard {
            return Card.TextCard(
                gson.fromJson(jsonObject, Text::class.java)
            )
        }

        private fun getTitleCard(jsonObject: JsonObject): Card.TitleCard {
            val cardJsonObject = jsonObject.get(CARD_KEY).asJsonObject
            return Card.TitleCard(
                gson.fromJson(cardJsonObject.get(TITLE_KEY), Text::class.java),
                gson.fromJson(cardJsonObject.get(DESCRIPTION_KEY), Text::class.java)
            )
        }
        private fun getImageTitleDescriptionCard(jsonObject: JsonObject): Card.ImageCard {
            val cardJsonObject = jsonObject.get(CARD_KEY).asJsonObject
            return Card.ImageCard(
                gson.fromJson(cardJsonObject.get(IMAGE_KEY), Image::class.java),
                gson.fromJson(cardJsonObject.get(TITLE_KEY), Text::class.java),
                gson.fromJson(cardJsonObject.get(DESCRIPTION_KEY), Text::class.java)
            )
        }
        companion object {
            const val CARD_TYPE = "card_type"
            const val CARD_TYPE_TEXT = "text"
            const val CARD_KEY = "card"
            const val DESCRIPTION_KEY = "description"
            const val TITLE_KEY = "title"
            const val CARD_TYPE_IMAGE_TITLE_DESCRIPTION = "image_title_description"
            const val IMAGE_KEY = "image"
            const val CARD_TYPE_TITLE_DESCRIPTION = "title_description"
        }
    }
}