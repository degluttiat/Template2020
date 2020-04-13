package com.alenal.template2020

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.alenal.template2020.model.Movie
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView()

        btnOpenAbout.setOnClickListener(this)
        btnOpenDetails.setOnClickListener(this)
    }

    private fun setRecyclerView() {
        //recycler.layoutManager = LinearLayoutManager(recycler.context)
        val recyclerViewAdapter = RecyclerViewAdapter()

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = recyclerViewAdapter
        }

        recyclerViewAdapter.addItems(createMovies())
    }

    private fun createMovies() = listOf(
        Movie("ok", "to"),
        Movie("ok2", "to2"),
        Movie("ok3", "to3")
    )


    override fun onClick(v: View?) {
        when (v) {
            btnOpenAbout -> findNavController().navigate(R.id.action_homeFragment_to_aboutFragment)
            btnOpenDetails -> {
                //findNavController().navigate(R.id.action_homeFragment_to_detailsFragment)
                val movie = Movie("Title", "Description")
                val action = HomeFragmentDirections
                    .actionHomeFragmentToDetailsFragment("Kuku", movie)
                findNavController().navigate(action)
            }
        }
    }
}

