package com.vita_zaebymba.gifsearchapp.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.vita_zaebymba.gifsearchapp.data.Gif
import com.vita_zaebymba.gifsearchapp.R

// константа используется для передачи экземпляра класса Gif между различными компонентами приложения
// дополнение ключа именем пакета предотвращает конфликт имен с дополнениями других пакетов
private const val EXTRA_GIF = "com.vita_zaebymba.gifsearchapp.extra_gif"

/**
 * класс для отображения подробной информации о выбранном GIF-изображении
 * */
class GifDetailActivity : AppCompatActivity() {

    private lateinit var idTextView: TextView
    private lateinit var titleTextView: TextView
    private lateinit var urlTextView: TextView
    private lateinit var previewUrlTextView: TextView
    private lateinit var widthTextView: TextView
    private lateinit var heightTextView: TextView

    private lateinit var gif: Gif

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gif_detail)

        idTextView = findViewById(R.id.gif_id)
        titleTextView = findViewById(R.id.gif_title)
        urlTextView = findViewById(R.id.gif_url)
        previewUrlTextView = findViewById(R.id.gif_previewUrl)
        widthTextView = findViewById(R.id.gif_width)
        heightTextView = findViewById(R.id.gif_height)

        gif = intent.getSerializableExtra(EXTRA_GIF) as Gif

        idTextView.text = gif.id
        titleTextView.text = gif.title
        urlTextView.text = gif.url
        previewUrlTextView.text = gif.previewUrl
        widthTextView.text = gif.width.toString()
        heightTextView.text = gif.height.toString()
    }

    companion object {
        fun newIntent(packageContext: Context, gif: Gif): Intent {
            return Intent(packageContext, GifDetailActivity::class.java).apply {
                putExtra(EXTRA_GIF, gif)
            }
        }
    }
}