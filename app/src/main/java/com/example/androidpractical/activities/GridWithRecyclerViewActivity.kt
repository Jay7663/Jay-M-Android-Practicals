package com.example.androidpractical.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractical.R
import com.example.androidpractical.adapters.GridViewAdapter
import com.example.androidpractical.adapters.RecyclerAdapter
import com.example.androidpractical.models.Product

class GridWithRecyclerViewActivity : AppCompatActivity() {

    var productsArrayList: ArrayList<Product> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_with_recycler_view)

        val rvGridRecycler: RecyclerView = findViewById(R.id.rvGridRecycler)
        addProductsToArrayList()

        val adapter = GridViewAdapter(productsArrayList)
        val layoutManager = GridLayoutManager(this, 2)

        rvGridRecycler.apply {
            this.layoutManager = layoutManager
            this.itemAnimator = DefaultItemAnimator()
            this.adapter = adapter
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