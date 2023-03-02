package com.vita_zaebymba.gifsearchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class GifDetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_GIF = "extra_gif"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gif_detail)

        val gif: Gif = intent.getParcelableExtra(EXTRA_GIF)!!

        val gifTitle: TextView = findViewById(R.id.gif_title)
        gifTitle.text = gif.title
    }
}