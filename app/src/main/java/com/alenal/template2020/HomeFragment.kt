package com.alenal.template2020

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.parcel.Parcelize
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

        btnOpenAbout.setOnClickListener(this)
        btnOpenDetails.setOnClickListener(this)
    }

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

@Parcelize
data class Movie(val title: String, val description: String) : Parcelable
