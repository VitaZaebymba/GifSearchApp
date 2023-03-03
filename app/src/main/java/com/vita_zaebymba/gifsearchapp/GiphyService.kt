package com.vita_zaebymba.gifsearchapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyService {
    @GET("gifs/trending")
    suspend fun getTrendingGifs(
        @Query("api_key") apiKey: String = BuildConfig.GIPHY_API_KEY,
        @Query("limit") limit: Int = 25,
        @Query("offset") offset: Int = 0,

    ): Response<GiphyApiResponse>

}