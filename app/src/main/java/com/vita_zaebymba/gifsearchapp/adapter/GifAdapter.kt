package com.vita_zaebymba.gifsearchapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vita_zaebymba.gifsearchapp.R
import com.vita_zaebymba.gifsearchapp.data.Gif

// класс для отображения списка GIF-изображений в RecyclerView
class GifAdapter(var gifs: List<Gif>, private val onItemClick: (Gif) -> Unit) : RecyclerView.Adapter<GifAdapter.ViewHolder>() { // принимает список gif-изображений и функцию onItemClick, которая будет вызываться при нажатии на элемент списка

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) { // Внутренний класс ViewHolder используется для создания представлений элементов списка и связывания их с данными
        private val gifImage: ImageView = itemView.findViewById(R.id.gif_image)

// содержит ссылки на представления элемента списка (в данном случае ImageView) и метод bind(), который связывает данные GIF-изображения с представлениями

        fun bind(gif: Gif) { // использует библиотеку Glide для загрузки предварительного изображения GIF с помощью URL-адреса, указанного в свойстве previewUrl экземпляра класса Gif
            Glide.with(itemView.context)
                .load(gif.previewUrl)
                .into(gifImage)

            itemView.setOnClickListener { // Функция устанавливает слушатель нажатий на элементе списка
                onItemClick(gif)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder { // Метод onCreateViewHolder создает новый ViewHolder, заполняя его данными из макета элемента списка
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_gif, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) { // Метод onBindViewHolder вызывает метод bind() для ViewHolder, передавая ему данные GIF-изображения для связывания с представлением элемента списка
        holder.bind(gifs[position])
    }

    override fun getItemCount(): Int { // Метод getItemCount возвращает количество элементов в списке GIF-изображений
        return gifs.size
    }
}