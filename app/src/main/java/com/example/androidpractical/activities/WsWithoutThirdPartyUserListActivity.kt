package com.example.androidpractical.activities

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractical.R
import com.example.androidpractical.adapters.UsersRecyclerAdapter
import com.example.androidpractical.interfaces.ApiInterface
import com.example.androidpractical.interfaces.ApiInterface.Companion.getRetrofitObject
import com.example.androidpractical.models.ApiUser
import com.example.androidpractical.models.CreateUserRequest
import com.example.androidpractical.utils.Constants.GET
import com.example.androidpractical.utils.Constants.TWO_HUNDRED_ONE
import com.example.androidpractical.utils.Constants.ZERO
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.net.HttpURLConnection
import java.net.URL

class WsWithoutThirdPartyUserListActivity : AppCompatActivity() {

    private var usersArrayList: ArrayList<ApiUser.Data> = ArrayList()
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ws_without_third_party_user_list)

        initialDataLoading()
    }

    private fun initialDataLoading() {
        val rvUserList: RecyclerView = findViewById(R.id.rvUserList)
        val fabAddUser: FloatingActionButton = findViewById(R.id.fabAddUser)
        progressBar = findViewById(R.id.progressBar)
        progressBar.visibility = View.VISIBLE
        var adapter = UsersRecyclerAdapter(usersArrayList, this)
        val layoutManager = LinearLayoutManager(applicationContext)

        rvUserList.apply {
            this.layoutManager = layoutManager
            this.itemAnimator = DefaultItemAnimator()
            this.adapter = adapter
        }

        Thread {
            try {
                val result = apiCall()
                runOnUiThread {
                    if (result) {
                        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                        adapter = UsersRecyclerAdapter(usersArrayList, this)
                        rvUserList.adapter = adapter
                        progressBar.visibility = View.GONE
                    } else {
                        Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                        progressBar.visibility = View.GONE
                    }
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }.start()

        rvUserList.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

        fabAddUser.setOnClickListener {
            generateAlert()
        }
    }

    private fun generateAlert() {
        val dialog = Dialog(this@WsWithoutThirdPartyUserListActivity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.cuctom_add_user_alert)

        val dialogAttributes = WindowManager.LayoutParams()
        dialogAttributes.width = WindowManager.LayoutParams.MATCH_PARENT
        dialogAttributes.height = WindowManager.LayoutParams.WRAP_CONTENT

        dialog.window?.attributes = dialogAttributes

        val etName = dialog.findViewById<EditText>(R.id.etName)
        val etJob = dialog.findViewById<EditText>(R.id.etJob)
        val btnAddUser = dialog.findViewById<Button>(R.id.btnAddUser)

        btnAddUser.setOnClickListener {
            val name = etName.text.toString()
            val job = etJob.text.toString()
            createUserWithRetrofit(name, job)
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun createUserWithRetrofit(name: String, job: String) {
        val apiInterface = getRetrofitObject().create(ApiInterface::class.java)
        val createUserRequest = CreateUserRequest(name, job)

        val loginAPI = apiInterface.createUser(createUserRequest)
        loginAPI.enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                if (response.code() == TWO_HUNDRED_ONE) {
                    Toast.makeText(
                        this@WsWithoutThirdPartyUserListActivity,
                        "Successfully created User",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this@WsWithoutThirdPartyUserListActivity,
                        "Failed",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                Toast.makeText(
                    this@WsWithoutThirdPartyUserListActivity,
                    "Failed",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    private fun apiCall(): Boolean {
        val requestURL = URL(getString(R.string.reqres_get_users_url_delay_3))

        with(requestURL.openConnection() as HttpURLConnection) {
            requestMethod = GET
            if (responseCode == HttpURLConnection.HTTP_OK) {
                val response = inputStream.bufferedReader().use { it.readText() }
                val jsonArray = JSONObject(response).getJSONArray(getString(R.string.data))
                usersArrayList.clear()
                for (index in ZERO until jsonArray.length()) {
                    usersArrayList.add(
                        ApiUser.Data(
                            jsonArray.getJSONObject(index).getInt(getString(R.string.id)),
                            jsonArray.getJSONObject(index).getString(getString(R.string.email)),
                            jsonArray.getJSONObject(index).getString(getString(R.string.first_name)),
                            jsonArray.getJSONObject(index).getString(getString(R.string.last_name)),
                            jsonArray.getJSONObject(index).getString(getString(R.string.avatar))
                        )
                    )
                }
                return true
            } else {
                return false
            }
        }
    }
}