package com.vita_zaebymba.gifsearchapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyService {
    @GET("gifs/trending")
    suspend fun searchGifs(
        @Query("api_key") apiKey: String = BuildConfig.GIPHY_API_KEY,
        @Query("offset") offset: String = "0",
        @Query("limit") limit: Int = 25,
    ): Response<GiphyApiResponse>

}