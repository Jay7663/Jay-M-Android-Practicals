package com.example.androidpractical.activities

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractical.R
import com.example.androidpractical.adapters.ExpandableRecyclerAdapter
import com.example.androidpractical.models.Movie

class SearchViewActivity : AppCompatActivity() {

    private var movieArrayList: ArrayList<Movie> = ArrayList()
    private var filteredArrayList: ArrayList<Movie> = ArrayList()
    private lateinit var recyclerView: RecyclerView
    private lateinit var tvNotFound: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_view)

        recyclerView = findViewById(R.id.recyclerView)
        val searchView: SearchView = findViewById(R.id.searchView)
        tvNotFound = findViewById(R.id.tvNotFound)

        fillMoviesDataToArrayList()
        filteredArrayList = movieArrayList

        val layoutManager = LinearLayoutManager(this)
        recyclerView.apply {
            this.layoutManager = layoutManager
            this.itemAnimator = DefaultItemAnimator()
        }

        setAdapter(filteredArrayList)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(this@SearchViewActivity, "Filter is Realtime", Toast.LENGTH_SHORT).show()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterData(newText)
                return true
            }
        })
    }

    private fun filterData(string: String?) {
        filteredArrayList = movieArrayList.filter { it.name.contains(string.toString(), true) } as ArrayList<Movie>
        if (filteredArrayList.isEmpty()) {
            setAdapter(filteredArrayList)
            tvNotFound.visibility = View.VISIBLE
        } else {
            tvNotFound.visibility = View.GONE
            setAdapter(filteredArrayList)
        }
    }

    private fun setAdapter(dataArrayList: ArrayList<Movie>) {
        val adapter = ExpandableRecyclerAdapter(dataArrayList)
        recyclerView.adapter = adapter
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