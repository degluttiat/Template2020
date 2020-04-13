package com.alenal.template2020.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alenal.template2020.R
import com.alenal.template2020.model.Movie

// В конструктор пердается обьект типа HomeFragment (ссылка на фрагмент)
// А мы делаем ему кастинг в "OnClickL" чтобы получить доступ только к
// функциям даанного интерфейса а не ко всему фрагменту
// Мы можем это сделать потому что наш фрагмент реализует интерфейс "OnClickL"
class RecyclerViewAdapter(private val onClickL: OnClickL) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var data = listOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MovieViewHolder(v, onClickL)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MovieViewHolder).onBindViewHolder(data[position])
    }

    fun addItems(list: List<Movie>) {
        data = list
    }

    interface OnClickL {
        fun onMovieClick(position: Int)
    }
}

