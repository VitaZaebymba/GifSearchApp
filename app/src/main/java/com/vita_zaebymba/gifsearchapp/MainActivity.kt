package com.vita_zaebymba.gifsearchapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    private val giphyClient = GiphyClient()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gifList: RecyclerView = findViewById(R.id.gif_list)
        gifList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val adapter = GifAdapter(emptyList()) { gif ->
            val intent = Intent(this, GifDetailActivity::class.java)
            intent.putExtra(GifDetailActivity.EXTRA_GIF, gif as Serializable)
            startActivity(intent)
        }
        gifList.adapter = adapter

        lifecycleScope.launch {
            val gifs = giphyClient.getTrendingGifs()
            adapter.gifs = gifs
            adapter.notifyDataSetChanged()
        }
    }
}

