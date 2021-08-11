package com.mobicatz.mobicatz.data.dto

import com.google.gson.annotations.SerializedName

data class MobicaTzRecyclerViewData(
        @SerializedName
        ("page") val page: Page
)

data class Page(
        @SerializedName
        ("cards") val cards: List<Cards>
)

data class Cards(
        @SerializedName
        ("card_type") val card_type: String,
        @SerializedName
        ("card") val card: Card
)

data class Card(
        @SerializedName
        ("value") val value: String,
        @SerializedName
        ("attributes") val attributes: Attributes
)

data class Attributes(
        @SerializedName
        ("text_color") val text_color: String,
         @SerializedName
        ("font") val font: Font
)

data class Font(
         @SerializedName
        ("size") val size: Int
)
