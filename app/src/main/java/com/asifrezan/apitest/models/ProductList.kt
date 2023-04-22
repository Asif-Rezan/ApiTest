package com.asifrezan.apitest.models

data class ProductList(
    val PageInfo: PageInfo,
    val ProductList: List<Product>,
    val Success: Int,
    val error: Boolean
)