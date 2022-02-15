package com.example.androidpractical.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.example.androidpractical.R
import com.example.androidpractical.adapters.ProductsAdapter
import com.example.androidpractical.models.Product

class ListViewActivity : AppCompatActivity() {

    var productsArrayList: ArrayList<Product> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val listView: ListView = findViewById(R.id.listView)
        addProductsToArrayList()

        val numbersAdapter = ProductsAdapter(this, productsArrayList)
        listView.adapter = numbersAdapter

        listView.isClickable = true
        listView.setOnItemClickListener { adapterView, view, position, id ->
            Toast.makeText(this, "Selected Item $position", Toast.LENGTH_SHORT).show()
        }
    }

    private fun addProductsToArrayList() {
        productsArrayList.add(
            Product(
                R.drawable.ic_baseline_add_shopping_cart_24,
                getString(R.string.product_mobile_title),
                getString(
                    R.string.product_mobile_description
                ),
                false
            )
        )
        productsArrayList.add(
            Product(
                R.drawable.ic_baseline_work_outline_24,
                getString(R.string.product_television_title),
                getString(
                    R.string.product_telivision_description
                ),
                false
            )
        )
        productsArrayList.add(
            Product(
                R.drawable.ic_baseline_list_alt_24,
                getString(R.string.product_computer_title),
                getString(
                    R.string.product_computer_description
                ),
                false
            )
        )
        productsArrayList.add(
            Product(
                R.drawable.ic_baseline_add_shopping_cart_24,
                getString(R.string.product_monitor_title),
                getString(
                    R.string.product_monitor_description
                ),
                false
            )
        )
        productsArrayList.add(
            Product(
                R.drawable.ic_baseline_add_shopping_cart_24,
                getString(R.string.product_mobile_title),
                getString(
                    R.string.product_mobile_description
                ),
                false
            )
        )
        productsArrayList.add(
            Product(
                R.drawable.ic_baseline_work_outline_24,
                getString(R.string.product_television_title),
                getString(
                    R.string.product_telivision_description
                ),
                false
            )
        )
        productsArrayList.add(
            Product(
                R.drawable.ic_baseline_list_alt_24,
                getString(R.string.product_computer_title),
                getString(
                    R.string.product_computer_description
                ),
                false
            )
        )
        productsArrayList.add(
            Product(
                R.drawable.ic_baseline_add_shopping_cart_24,
                getString(R.string.product_monitor_title),
                getString(
                    R.string.product_monitor_description
                ),
                false
            )
        )
        productsArrayList.add(
            Product(
                R.drawable.ic_baseline_add_shopping_cart_24,
                getString(R.string.product_mobile_title),
                getString(
                    R.string.product_mobile_description
                ),
                false
            )
        )
        productsArrayList.add(
            Product(
                R.drawable.ic_baseline_work_outline_24,
                getString(R.string.product_television_title),
                getString(
                    R.string.product_telivision_description
                ),
                false
            )
        )
        productsArrayList.add(
            Product(
                R.drawable.ic_baseline_list_alt_24,
                getString(R.string.product_computer_title),
                getString(
                    R.string.product_computer_description
                ),
                false
            )
        )
        productsArrayList.add(
            Product(
                R.drawable.ic_baseline_add_shopping_cart_24,
                getString(R.string.product_monitor_title),
                getString(
                    R.string.product_monitor_description
                ),
                false
            )
        )
    }
}