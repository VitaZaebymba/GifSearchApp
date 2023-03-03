package com.vita_zaebymba.gifsearchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class GifDetailActivity : AppCompatActivity() { // класс для отображения подробной информации о выбранном GIF-изображении
    companion object {
        const val EXTRA_GIF = "extra_gif" // константа используется для передачи экземпляра класса Gif между различными компонентами приложения
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gif_detail)

        val gif: Gif = intent.getParcelableExtra(EXTRA_GIF)!!


        val gifTitle: TextView = findViewById(R.id.gif_title) // текстовому полю gifTitle устанавливается текст заголовка GIF-изображения с помощью метода setText, используя свойство title объекта gif
        gifTitle.text = gif.title


    }
}