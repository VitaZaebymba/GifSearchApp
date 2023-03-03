package com.vita_zaebymba.gifsearchapp

import com.vita_zaebymba.gifsearchapp.BuildConfig.GIPHY_API_KEY
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class GiphyClient {
    private val service = Retrofit.Builder()
        .baseUrl("https://api.giphy.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GiphyService::class.java) //


    suspend fun searchGifs(query: String): List<Gif> {
        val response = service.searchGifs(GIPHY_API_KEY, query)
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

    /*suspend fun getTrendingGifs(query: String): List<Gif> {
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
    }*/

}
