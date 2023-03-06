package com.vita_zaebymba.gifsearchapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyService { //для взаимодействия с API сервиса Giphy. Он объявляет метод getTrendingGifs, который отправляет GET-запрос на сервер,
    // чтобы получить список популярных GIF-изображений. Метод асинхронный, то есть выполнение запроса происходит в фоновом потоке,
    // и он использует аннотацию @GET для указания типа запроса и конечной точки, к которой он отправляется.
    // Также метод принимает параметры запроса в качестве аргументов функции и возвращает объект типа Response<GiphyApiResponse>.
    @GET("gifs/trending")
    suspend fun getTrendingGifs(
        @Query("api_key") apiKey: String = BuildConfig.GIPHY_API_KEY,
        @Query("limit") limit: Int = 25,
        @Query("offset") offset: Int = 0,

        ): Response<GiphyApiResponse>

    @GET("gifs/search")
    suspend fun getSearchGifs(
        @Query("api_key") apiKey: String = BuildConfig.GIPHY_API_KEY,
        @Query("q") q : String,
        @Query("limit") limit: Int = 25,
        @Query("offset") offset: Int = 0,
    ): Response<GiphyApiResponse>

}