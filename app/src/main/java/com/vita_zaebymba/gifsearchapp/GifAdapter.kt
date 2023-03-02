package com.vita_zaebymba.gifsearchapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class GifAdapter(var gifs: List<Gif>, private val onItemClick: (Gif) -> Unit) : RecyclerView.Adapter<GifAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val gifImage: ImageView = itemView.findViewById(R.id.gif_image)

        fun bind(gif: Gif) {
            Glide.with(itemView.context)
                .load(gif.previewUrl)
                .into(gifImage)

            itemView.setOnClickListener {
                onItemClick(gif)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_gif, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(gifs[position])
    }

    override fun getItemCount(): Int {
        return gifs.size
    }
}