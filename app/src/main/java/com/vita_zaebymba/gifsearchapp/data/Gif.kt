package com.vita_zaebymba.gifsearchapp.data

data class Gif( //класс для хранения информации о GIF
    val id: String,
    val title: String,
    val url: String,
    val previewUrl: String,
    val width: Int,
    val height: Int
) : java.io.Serializable
