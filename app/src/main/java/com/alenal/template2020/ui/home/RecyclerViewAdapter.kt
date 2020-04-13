package com.alenal.template2020.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alenal.template2020.R
import com.alenal.template2020.model.Movie

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var data = listOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MovieViewHolder(v)
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
}

