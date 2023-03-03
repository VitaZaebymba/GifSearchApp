package com.vita_zaebymba.gifsearchapp

import com.google.gson.annotations.SerializedName

// код определяет несколько классов, которые используются для разбора ответа API сервиса Giphy

data class GiphyApiResponse( // является моделью данных для корневого объекта ответа API
    val data: List<GiphyGif> // свойство data, которое представляет список GIF-изображений, возвращаемых сервисом
)

data class GiphyGif( // представляет объект GIF-изображения в ответе API
    val id: String,
    val title: String,
    val images: GiphyImages
)

data class GiphyImages( // содержит свойство fixedWidth, которое представляет объект изображения GIF с фиксированной шириной
    @SerializedName("fixed_width")
    val fixedWidth: GiphyImage

// SerializedName используется для указания того, что имя поля JSON, которое соответствует свойству fixedWidth, должно быть "fixed_width",
// таким образом, это свойство будет правильно разобрано с помощью библиотеки парсинга JSON

)

data class GiphyImage(
    val url: String,
    val width: Int,
    val height: Int
)
