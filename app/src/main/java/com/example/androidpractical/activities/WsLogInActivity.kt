package com.example.androidpractical.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpractical.R
import com.example.androidpractical.interfaces.ApiInterface
import com.example.androidpractical.interfaces.ApiInterface.Companion.getRetrofitObject
import com.example.androidpractical.models.LogInRequest
import com.example.androidpractical.utils.Constants.POST
import com.example.androidpractical.utils.Constants.TWO_HUNDRED
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

class WsLogInActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ws_log_in)

        initialDataLoading()
    }

    private fun initialDataLoading() {
        val btnLogIn: Button = findViewById(R.id.btnLogIn)
        val etEmail: EditText = findViewById(R.id.etEmail)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val btnLogInWithRetrofit: Button = findViewById(R.id.btnLogInWithRetrofit)
        progressBar = findViewById(R.id.progressBar)

        btnLogIn.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            Thread {
                try {
                    val result = logInWithoutThirdParty(etEmail.text.toString(), etPassword.text.toString())
                    runOnUiThread {
                        if (result) {
                            progressBar.visibility = View.GONE
                            val intent = Intent(this, WsWithoutThirdPartyUserListActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                            progressBar.visibility = View.GONE
                        }
                    }
                } catch (ex: Exception) {
                    ex.printStackTrace()
                }
            }.start()
        }

        btnLogInWithRetrofit.setOnClickListener {
            logInWithRetrofit(etEmail.text.toString(), etPassword.text.toString())
        }
    }

    private fun logInWithRetrofit(email: String, password: String) {
        progressBar.visibility = View.VISIBLE
        val apiInterface = getRetrofitObject().create(ApiInterface::class.java)
        val loginRequest = LogInRequest(email, password)
        val loginAPI = apiInterface.logInWithRetrofit(loginRequest)

        loginAPI.enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                if (response.code() == TWO_HUNDRED) {
                    progressBar.visibility = View.GONE
                    val intent = Intent(this@WsLogInActivity, WsRetrofitUserListActivity::class.java)
                    startActivity(intent)
                } else {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this@WsLogInActivity, "Failed", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                progressBar.visibility = View.GONE
                Toast.makeText(this@WsLogInActivity, "Failed", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun logInWithoutThirdParty(email: String, password: String): Boolean {
        val credentials = JSONObject()
        credentials.put(getString(R.string.email), email)
        credentials.put(getString(R.string.password), password)
        val requestURL = URL(getString(R.string.without_third_party_log_in_full_url))
        with(requestURL.openConnection() as HttpURLConnection) {
            requestMethod = POST
            setRequestProperty("Content-Type", "application/json")
            val wr = OutputStreamWriter(outputStream)
            wr.write(credentials.toString())
            wr.flush()
            return try {
                BufferedReader(InputStreamReader(inputStream)).use {
                    val response = StringBuffer()
                    var inputLine = it.readLine()
                    while (inputLine != null) {
                        response.append(inputLine)
                        inputLine = it.readLine()
                    }
                }
                responseCode == TWO_HUNDRED
            } catch (ex: Exception) {
                false
            }
        }
    }
}