package com.vita_zaebymba.gifsearchapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GiphyClient {
    private val service = Retrofit.Builder()
        .baseUrl("https://api.giphy.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GiphyService::class.java)

    suspend fun getTrendingGifs(): List<Gif> {
        val response = service.getTrendingGifs()
        return if (response.isSuccessful) {
            response.body()?.data?.map { gif ->
                Gif(
                    id = gif.id,
                    title = gif.title,
                    url = gif.images.fixedWidth.url,
                    previewUrl = gif.images.fixedWidth.url,
                    width = gif.images.fixedWidth.width,
                    height = gif.images.fixedWidth.height
                )
            } ?: emptyList()
        } else {
            emptyList()
        }
    }
}