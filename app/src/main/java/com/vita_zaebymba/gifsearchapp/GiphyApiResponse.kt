package com.vita_zaebymba.gifsearchapp

import com.google.gson.annotations.SerializedName

data class GiphyApiResponse(
    val data: List<GiphyGif>
)

data class GiphyGif(
    val id: String,
    val title: String,
    val images: GiphyImages
)

data class GiphyImages(
    @SerializedName("fixed_width") val fixedWidth: GiphyImage
)

data class GiphyImage(
    val url: String,
    val width: Int,
    val height: Int
)
