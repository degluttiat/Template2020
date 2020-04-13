package com.alenal.template2020.ui.home

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alenal.template2020.model.Movie
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item.*

class MovieViewHolder(v: View) : RecyclerView.ViewHolder(v), LayoutContainer {
    override val containerView: View? = v

    @SuppressLint("SetTextI18n")
    fun onBindViewHolder(movie: Movie) {
        tvTitle.text = "${movie.title} - ${movie.description}"
    }
}