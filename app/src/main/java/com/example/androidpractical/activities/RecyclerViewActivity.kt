package com.example.androidpractical.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractical.R
import com.example.androidpractical.adapters.RecyclerAdapter
import com.example.androidpractical.models.Product

class RecyclerViewActivity : AppCompatActivity() {

    var productsArrayList: ArrayList<Product> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        addProductsToArrayList()

        val adapter = RecyclerAdapter(productsArrayList)
        val layoutManager = LinearLayoutManager(applicationContext)

        recyclerView.apply {
            this.layoutManager = layoutManager
            this.itemAnimator = DefaultItemAnimator()
            this.adapter = adapter
        }

        recyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )
    }

    private fun addProductsToArrayList() {
        productsArrayList.apply {
            add(
                Product(
                    R.drawable.ic_baseline_add_shopping_cart_24,
                    getString(R.string.product_mobile_title),
                    getString(
                        R.string.product_mobile_description
                    ),
                    false
                )
            )
            add(
                Product(
                    R.drawable.ic_baseline_work_outline_24,
                    getString(R.string.product_television_title),
                    getString(
                        R.string.product_telivision_description
                    ),
                    false
                )
            )
            add(
                Product(
                    R.drawable.ic_baseline_list_alt_24,
                    getString(R.string.product_computer_title),
                    getString(
                        R.string.product_computer_description
                    ),
                    false
                )
            )
            add(
                Product(
                    R.drawable.ic_baseline_add_shopping_cart_24,
                    getString(R.string.product_monitor_title),
                    getString(
                        R.string.product_monitor_description
                    ),
                    false
                )
            )
            add(
                Product(
                    R.drawable.ic_baseline_add_shopping_cart_24,
                    getString(R.string.product_mobile_title),
                    getString(
                        R.string.product_mobile_description
                    ),
                    false
                )
            )
            add(
                Product(
                    R.drawable.ic_baseline_work_outline_24,
                    getString(R.string.product_television_title),
                    getString(
                        R.string.product_telivision_description
                    ),
                    false
                )
            )
            add(
                Product(
                    R.drawable.ic_baseline_list_alt_24,
                    getString(R.string.product_computer_title),
                    getString(
                        R.string.product_computer_description
                    ),
                    false
                )
            )
            add(
                Product(
                    R.drawable.ic_baseline_add_shopping_cart_24,
                    getString(R.string.product_monitor_title),
                    getString(
                        R.string.product_monitor_description
                    ),
                    false
                )
            )
            add(
                Product(
                    R.drawable.ic_baseline_add_shopping_cart_24,
                    getString(R.string.product_mobile_title),
                    getString(
                        R.string.product_mobile_description
                    ),
                    false
                )
            )
            add(
                Product(
                    R.drawable.ic_baseline_work_outline_24,
                    getString(R.string.product_television_title),
                    getString(
                        R.string.product_telivision_description
                    ),
                    false
                )
            )
            add(
                Product(
                    R.drawable.ic_baseline_list_alt_24,
                    getString(R.string.product_computer_title),
                    getString(
                        R.string.product_computer_description
                    ),
                    false
                )
            )
            add(
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
}