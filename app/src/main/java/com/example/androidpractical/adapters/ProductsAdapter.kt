package com.example.androidpractical.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import com.example.androidpractical.R
import com.example.androidpractical.models.Product

class ProductsAdapter(private val context: Activity, private val arrayList: ArrayList<Product>) :
    ArrayAdapter<Product>(context, R.layout.custom_list_view_item, arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val viewHolder: ViewHolder
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.custom_list_view_item, null)

        viewHolder = ViewHolder(view)
        view.tag = viewHolder

        viewHolder.apply {
            imageView.setImageResource(arrayList[position].productImage)
            titleText.text = arrayList[position].productTitle
            subtitleText.text = arrayList[position].productDescription

            checkBox.setOnClickListener {
                arrayList[position].checked = !arrayList[position].checked
                notifyDataSetChanged()
            }

            checkBox.isChecked = arrayList[position].checked
        }

        return view
    }

    private class ViewHolder(view: View) {
        val imageView: ImageView = view.findViewById(R.id.ivImage)
        val titleText: TextView = view.findViewById(R.id.tvTitle)
        val subtitleText: TextView = view.findViewById(R.id.tvDescription)
        val checkBox: CheckBox = view.findViewById(R.id.checkBox)
    }
}