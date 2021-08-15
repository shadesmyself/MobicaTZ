package com.mobicatz.mobicatz.data.dto

import com.google.gson.annotations.SerializedName

data class CardsData(
    @SerializedName
        ("page") val page: Page
)

data class Page(
    @SerializedName("cards")
    val cards: List<Card>
)

sealed class Card {
    data class TitleCard(
        @SerializedName("title")
        val title: Text,
        @SerializedName("description")
        val description: Text
    ) : Card()

    data class TextCard(
        val text: Text
    ) : Card()

    data class ImageCard(
        @SerializedName("image")
        val image: Image,
        @SerializedName("title")
        val title: Text,
        @SerializedName("description")
        val description: Text
    ) : Card()
}

data class Size(
    @SerializedName("height")
    val height: Int,
    @SerializedName("weight")
    val weight: Int
)

data class Text(
    @SerializedName("value")
    val value: String,
    @SerializedName("attributes")
    val textAtrs: TextAtrs
)

data class Image(
    @SerializedName("url")
    val url: String,
    @SerializedName("size")
    val size: Size,
)

data class Font(
    @SerializedName("size")
    val size: Int,
)

data class TextAtrs(
    @SerializedName("text_color")
    val color: String,
    @SerializedName("font")
    val font: Font
)



