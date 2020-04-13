package com.alenal.template2020.ui.home

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alenal.template2020.model.Movie
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item.*

class MovieViewHolder(v: View, private val onClickL: RecyclerViewAdapter.OnClickL) :
    RecyclerView.ViewHolder(v), LayoutContainer, View.OnClickListener {
    override val containerView: View? = v

    init {
        v.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun onBindViewHolder(movie: Movie) {
        tvTitle.text = "${movie.title} - ${movie.description}"
    }

    override fun onClick(v: View?) {
        if (v != null && adapterPosition != RecyclerView.NO_POSITION) {
            onClickL.onMovieClick(adapterPosition)
        }
    }
}