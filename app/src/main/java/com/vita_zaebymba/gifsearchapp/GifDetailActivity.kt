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

        /*val gifId: TextView = findViewById(R.id.gif_id)
        gifId.text = gif.id*/

        /*val gifTitle: TextView = findViewById(R.id.gif_title)
        gifTitle.text = gif.title

        val gifUrl: TextView = findViewById(R.id.gif_url)
        gifUrl.text = gif.url

        val gifPreviewUrl: TextView = findViewById(R.id.gif_previewUrl)
        gifPreviewUrl.text = gif.previewUrl

        val gifWidth: TextView = findViewById(R.id.gif_width)
        gifWidth.text = gif.width.toString()

        val gifHeight: TextView = findViewById(R.id.gif_height)
        gifHeight.text = gif.height.toString()*/
    }
}