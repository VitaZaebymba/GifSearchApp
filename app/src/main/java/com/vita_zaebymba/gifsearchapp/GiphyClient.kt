package com.vita_zaebymba.gifsearchapp

import com.vita_zaebymba.gifsearchapp.data.Gif
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class GiphyClient { // Класс GiphyClient представляет клиент для получения данных из API Giphy
    private val service = Retrofit.Builder() //Конструктор класса создает экземпляр Retrofit и настраивает его, указывая базовый URL и конвертер JSON.
        // Затем создается экземпляр интерфейса GiphyService, и содержит методы для взаимодействия с API Giphy
        .baseUrl("https://api.giphy.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GiphyService::class.java)

    suspend fun getTrendingGifs(): List<Gif> { // вызывает метод getTrendingGifs() в GiphyService, чтобы получить список трендовых GIF-изображений.
        // Если ответ успешен, он преобразует данные ответа в список объектов Gif, используя метод map(). Если ответ не удался, он возвращает пустой список.
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

    suspend fun getSearchGifs(text: String) : List<Gif> {
        val response = service.getSearchGifs(q = text)
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