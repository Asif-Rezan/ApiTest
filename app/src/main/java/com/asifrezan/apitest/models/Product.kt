package com.asifrezan.apitest.models

data class Product(
    val BrandName: String,
    val CategoryName: String,
    val ChildList: List<List<Int>>,
    val Code: String,
    val ColorName: String,
    val CostPrice: Double,
    val CreateDate: String,
    val CurrentStock: Double,
    val Description: String,
    val Id: Int,
    val ImagePath: Any,
    val ModelName: String,
    val Name: String,
    val OldPrice: Double,
    val ParentCode: String,
    val Price: Double,
    val ProductBarcode: String,
    val SizeName: String,
    val Type: String,
    val UnitName: String,
    val UpdateDate: String,
    val VariantName: String,
    val WarehouseList: List<Warehouse>
)