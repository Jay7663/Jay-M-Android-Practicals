package com.example.androidpractical.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractical.R
import com.example.androidpractical.models.Product

class RecyclerAdapter(private var arrayList: ArrayList<Product>) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_list_view_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.apply {
            ivImage.setImageResource(arrayList[position].productImage)
            tvTitle.text = arrayList[position].productTitle
            tvDescription.text = arrayList[position].productDescription

            checkBox.setOnClickListener {
                arrayList[position].checked = !arrayList[position].checked
                notifyItemChanged(position)
            }

            checkBox.isChecked = arrayList[position].checked
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var ivImage: ImageView = view.findViewById(R.id.ivImage)
        var tvTitle: TextView = view.findViewById(R.id.tvTitle)
        var tvDescription: TextView = view.findViewById(R.id.tvDescription)
        var checkBox: CheckBox = view.findViewById(R.id.checkBox)
    }
}