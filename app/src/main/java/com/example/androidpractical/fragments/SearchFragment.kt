package com.example.androidpractical.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractical.R
import com.example.androidpractical.adapters.ExpandableRecyclerAdapter
import com.example.androidpractical.models.Movie

class SearchFragment : Fragment() {

    var movieArrayList: ArrayList<Movie> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_search, container, false)
        val recyclerViewExpandable: RecyclerView = view.findViewById(R.id.recyclerViewExpandable)

        fillMoviesDataToArrayList()

        val adapter = ExpandableRecyclerAdapter(movieArrayList)
        val layoutManager = LinearLayoutManager(context)

        recyclerViewExpandable.apply {
            this.layoutManager = layoutManager
            this.itemAnimator = DefaultItemAnimator()
            this.adapter = adapter
        }

        return view
    }

    private fun fillMoviesDataToArrayList() {
        movieArrayList.apply {
            add(
                Movie(
                    getString(R.string.movie_captain_america_name),
                    getString(R.string.movie_captain_america_real_name),
                    getString(R.string.movie_captain_america_team),
                    getString(R.string.movie_captain_america_first_appearance),
                    getString(R.string.movie_captain_america_created_by),
                    getString(R.string.movie_captain_america_publisher),
                    R.drawable.captainamerica,
                    getString(R.string.movie_captain_america_bio),
                    true
                )
            )
            add(
                Movie(
                    getString(R.string.movie_iron_man_name),
                    getString(R.string.movie_iron_man_real_name),
                    getString(R.string.movie_iron_man_team),
                    getString(R.string.movie_iron_man_first_appearance),
                    getString(R.string.movie_iron_man_created_by),
                    getString(R.string.movie_iron_man_publisher),
                    R.drawable.ironman,
                    getString(R.string.movie_iron_man_bio),
                    true
                )
            )
            add(
                Movie(
                    getString(R.string.movie_wolverine_name),
                    getString(R.string.movie_wolverine_real_name),
                    getString(R.string.movie_wolverine_team),
                    getString(R.string.movie_wolverine_first_appearance),
                    getString(R.string.movie_wolverine_created_by),
                    getString(R.string.movie_wolverine_publisher),
                    R.drawable.logan,
                    getString(R.string.movie_wolverine_bio),
                    true
                )
            )
            add(
                Movie(
                    getString(R.string.movie_spiderman_name),
                    getString(R.string.movie_spiderman_real_name),
                    getString(R.string.movie_spiderman_team),
                    getString(R.string.movie_spiderman_first_appearance),
                    getString(R.string.movie_spiderman_created_by),
                    getString(R.string.movie_spiderman_publisher),
                    R.drawable.spiderman,
                    getString(R.string.movie_spiderman_bio),
                    true
                )
            )
            add(
                Movie(
                    getString(R.string.movie_thor_name),
                    getString(R.string.movie_thor_real_name),
                    getString(R.string.movie_thor_team),
                    getString(R.string.movie_thor_first_appearance),
                    getString(R.string.movie_thor_created_by),
                    getString(R.string.movie_thor_publisher),
                    R.drawable.thor,
                    getString(R.string.movie_thor_bio),
                    true
                )
            )
        }
    }
}