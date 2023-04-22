package com.asifrezan.apitest.retrofit

import com.asifrezan.apitest.models.ProductList
import com.asifrezan.apitest.utils.Constants.AUTH_TOKEN
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ProductsApi {

    @GET("/invoiceapps/Values/GetProductList")
    @Headers("Authorization: Bearer $AUTH_TOKEN")
    suspend fun getProducts(@Query("PageNo") page : Int) : ProductList

}