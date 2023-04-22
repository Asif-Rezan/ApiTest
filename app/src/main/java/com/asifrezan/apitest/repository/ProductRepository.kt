package com.asifrezan.apitest.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.asifrezan.apitest.paging.ProductPagingSource
import com.asifrezan.apitest.retrofit.ProductsApi
import javax.inject.Inject

class ProductRepository @Inject constructor(val productsApi: ProductsApi) {

    fun getProduct() = Pager(
        config = PagingConfig(pageSize = 10, maxSize = 50),
        pagingSourceFactory = {ProductPagingSource(productsApi)}
    ).liveData

}