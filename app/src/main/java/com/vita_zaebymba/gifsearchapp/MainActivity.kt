package com.vita_zaebymba.gifsearchapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

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
            intent.putExtra(GifDetailActivity.EXTRA_GIF, gif.url)
            startActivity(intent)
        }
        gifList.adapter = adapter

        val searchBar: EditText = findViewById(R.id.search_bar)
        searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // not needed
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // not needed
            }

            override fun afterTextChanged(s: Editable?) {
                lifecycleScope.launch {
                    val query = s?.toString()?.trim() ?: ""
                    val gifs = giphyClient.getTrendingGifs(query)
                    adapter.gifs = gifs
                    adapter.notifyDataSetChanged()
                }
            }
        })
    }
}
