package com.example.androidpractical.activities

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.androidpractical.R
import com.example.androidpractical.interfaces.ApiInterface
import com.example.androidpractical.interfaces.ApiInterface.Companion.getRetrofitObject
import com.example.androidpractical.models.CreateUserRequest
import com.example.androidpractical.models.SIngleUser
import com.example.androidpractical.utils.Constants.INTENT_USER_ID
import com.example.androidpractical.utils.Constants.ZERO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URL

class WsSingleUserActivity : AppCompatActivity() {

    private lateinit var ivProfilePicture: ImageView
    private lateinit var tvName: TextView
    private lateinit var tvEmail: TextView
    private lateinit var requestUrl: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ws_single_user)

        val idOfUser = intent.getIntExtra(INTENT_USER_ID, ZERO)
        ivProfilePicture = findViewById(R.id.ivProfilePicture)
        tvName = findViewById(R.id.tvName)
        tvEmail = findViewById(R.id.tvEmail)
        tvName.text = idOfUser.toString()
        requestUrl = "api/users/$idOfUser"
        getUserFromAPI()
    }

    private fun getUserFromAPI() {
        val apiInterface = getRetrofitObject().create(ApiInterface::class.java)
        val retrofitData = apiInterface.getSpecificUser(requestUrl)

        retrofitData.enqueue(object : Callback<SIngleUser?> {
            override fun onResponse(call: Call<SIngleUser?>, response: Response<SIngleUser?>) {
                val responseBody = response.body()
                if (responseBody != null) {
                    val url = responseBody.data?.avatar
                    var image: Bitmap?
                    val handler = Handler(Looper.getMainLooper())

                    lifecycleScope.launch(Dispatchers.IO) {
                        val `in` = URL(url).openStream()
                        image = BitmapFactory.decodeStream(`in`)
                        handler.post {
                            ivProfilePicture.setImageBitmap(image)
                        }
                    }
                }
                tvName.text = getString(
                    R.string.user_name,
                    responseBody?.data?.firstName,
                    responseBody?.data?.lastName
                )
                tvEmail.text = responseBody?.data?.email
            }

            override fun onFailure(call: Call<SIngleUser?>, t: Throwable) {
                Toast.makeText(this@WsSingleUserActivity, "Failed", Toast.LENGTH_SHORT).show()
            }
        })
    }
}