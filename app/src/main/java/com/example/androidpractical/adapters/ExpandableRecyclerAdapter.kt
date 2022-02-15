package com.example.androidpractical.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractical.R
import com.example.androidpractical.models.Movie

class ExpandableRecyclerAdapter(private var movieAraayList: ArrayList<Movie>) :
    RecyclerView.Adapter<ExpandableRecyclerAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_expandable_text_view_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.apply {
            tvMovieName.text = movieAraayList[position].name
            imgPoster.setImageResource(movieAraayList[position].imageUrl)
            tvRealName.text = movieAraayList[position].realName
            tvTeam.text = movieAraayList[position].team
            tvFirstAppearance.text = movieAraayList[position].firstAppearance
            tvCreatedBy.text = movieAraayList[position].createdBy
            tvPublisher.text = movieAraayList[position].publisher
            tvBio.text = movieAraayList[position].bio
            cardExpandableRecycler.setOnClickListener {
                movieAraayList[position].isExpanded = !movieAraayList[position].isExpanded
                notifyItemChanged(position)
            }
        }

        if (movieAraayList[position].isExpanded) {
            holder.layoutMovieData.visibility = View.GONE
        } else {
            holder.layoutMovieData.visibility = View.VISIBLE
        }
    }

    override fun getItemCount(): Int {
        return movieAraayList.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvMovieName: TextView = view.findViewById(R.id.tvMovieName)
        var imgPoster: ImageView = view.findViewById(R.id.imgPoster)
        var tvRealName: TextView = view.findViewById(R.id.tvRealName)
        var tvTeam: TextView = view.findViewById(R.id.tvTeam)
        var tvFirstAppearance: TextView = view.findViewById(R.id.tvFirstAppearance)
        var tvCreatedBy: TextView = view.findViewById(R.id.tvCreatedBy)
        var tvPublisher: TextView = view.findViewById(R.id.tvPublisher)
        var tvBio: TextView = view.findViewById(R.id.tvBio)
        var layoutMovieData: ConstraintLayout = view.findViewById(R.id.layoutMovieData)
        var cardExpandableRecycler: CardView = view.findViewById(R.id.cardExpandableRecycler)
    }
}