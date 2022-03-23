package com.example.androidpractical.activities

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractical.R
import com.example.androidpractical.adapters.UsersRecyclerAdapter
import com.example.androidpractical.interfaces.ApiInterface
import com.example.androidpractical.models.ApiUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WsRetrofitUserListActivity : AppCompatActivity() {

    var userList: ArrayList<ApiUser.Data> = ArrayList()
    private lateinit var adapter: UsersRecyclerAdapter
    private lateinit var rvRetrofitUserList: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ws_retrofit_user_list)

        rvRetrofitUserList = findViewById(R.id.rvRetrofitUserList)
        val layoutManager = LinearLayoutManager(applicationContext)
        progressBar = findViewById(R.id.progressBar)
        rvRetrofitUserList.apply {
            this.layoutManager = layoutManager
            this.itemAnimator = DefaultItemAnimator()
        }
        requestForDataWithRetrofit()
    }

    private fun requestForDataWithRetrofit() {
        progressBar.visibility = View.VISIBLE

        val apiInterface = ApiInterface.getRetrofitObject().create(ApiInterface::class.java)
        val retrofitData = apiInterface.getData()

        retrofitData.enqueue(object : Callback<ApiUser?> {
            override fun onResponse(call: Call<ApiUser?>, response: Response<ApiUser?>) {
                val responseBody = response.body()?.data
                if (responseBody != null) {
                    userList = responseBody
                }
                progressBar.visibility = View.GONE
                adapter = UsersRecyclerAdapter(userList, this@WsRetrofitUserListActivity)
                rvRetrofitUserList.adapter = adapter
            }

            override fun onFailure(call: Call<ApiUser?>, t: Throwable) {
                progressBar.visibility = View.GONE
                Toast.makeText(this@WsRetrofitUserListActivity, "Failed", Toast.LENGTH_SHORT).show()
            }
        })
    }
}