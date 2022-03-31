package com.example.androidpractical.adapters

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractical.R
import com.example.androidpractical.activities.WsSingleUserActivity
import com.example.androidpractical.models.ApiUser
import com.example.androidpractical.utils.Constants.INTENT_USER_ID
import java.util.concurrent.Executors

class UsersRecyclerAdapter(
    private var usersArrayList: ArrayList<ApiUser.Data>,
    private var context: Activity
) :
    RecyclerView.Adapter<UsersRecyclerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_users_recycler_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.apply {
            val url = usersArrayList[position].profilePIc
            val executor = Executors.newSingleThreadExecutor()
            val handler = Handler(Looper.getMainLooper())
            var image: Bitmap? = null

            tvName.text = context.getString(
                R.string.user_name,
                usersArrayList[position].firstName,
                usersArrayList[position].lastName
            )
            tvEmail.text = usersArrayList[position].email

            executor.execute {
                try {
                    val `in` = java.net.URL(url).openStream()
                    image = BitmapFactory.decodeStream(`in`)
                    handler.post {
                        ivImage.setImageBitmap(image)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            ivImage.setOnClickListener {
                val intent = Intent(context, WsSingleUserActivity::class.java)
                intent.putExtra(INTENT_USER_ID, usersArrayList[position].id)
                startActivity(context, intent, null)
            }
        }
    }

    override fun getItemCount(): Int {
        return usersArrayList.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var ivImage: ImageView = view.findViewById(R.id.ivImage)
        var tvName: TextView = view.findViewById(R.id.tvName)
        var tvEmail: TextView = view.findViewById(R.id.tvEmail)
    }
}