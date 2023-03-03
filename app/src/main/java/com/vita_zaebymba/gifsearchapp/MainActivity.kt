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
    private val giphyClient = GiphyClient() // создает экземпляр GiphyClient и использует его для получения популярных GIF-изображений с помощью метода getTrendingGifs()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gifList: RecyclerView = findViewById(R.id.gif_list) // полученные данные используются для заполнения RecyclerView, который отображает список GIF-изображений
        gifList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val adapter = GifAdapter(emptyList()) { gif ->
            val intent = Intent(this, GifDetailActivity::class.java) // при нажатии на любой элемент списка, создается новый интент
            intent.putExtra(GifDetailActivity.EXTRA_GIF, gif.title) // передается выбранное изображение как дополнительная информация 
            startActivity(intent)
        }
        gifList.adapter = adapter

        lifecycleScope.launch { // корутина, которая асинхронно получает список популярных GIF-изображений из API Giphy и устанавливает его в адаптер RecyclerView
            val gifs = giphyClient.getTrendingGifs()
            adapter.gifs = gifs
            adapter.notifyDataSetChanged()
        }
    }

}