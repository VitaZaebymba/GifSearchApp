package com.vita_zaebymba.gifsearchapp

import com.giphy.sdk.core.network.api.Constants.API_KEY
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GiphyClient {
    private val service = Retrofit.Builder()
        .baseUrl("https://api.giphy.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GiphyService::class.java)

    suspend fun getTrendingGifs(query: String): List<Gif> {
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
