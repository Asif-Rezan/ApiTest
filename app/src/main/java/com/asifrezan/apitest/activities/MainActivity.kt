package com.asifrezan.apitest.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.asifrezan.apitest.R
import com.asifrezan.apitest.paging.LoaderAdapter
import com.asifrezan.apitest.paging.ProductPagingAdapter
import com.asifrezan.apitest.viewmodels.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ProductPagingAdapter
    lateinit var productViewModel: ProductViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.productList)
        adapter = ProductPagingAdapter()
        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter.withLoadStateHeaderAndFooter(
            header = LoaderAdapter(),
            footer = LoaderAdapter()
        )


        productViewModel.list.observe(this, Observer {
            adapter.submitData(lifecycle,it)
        })






    }
}