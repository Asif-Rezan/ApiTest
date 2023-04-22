package com.asifrezan.apitest.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.asifrezan.apitest.models.Product
import com.asifrezan.apitest.retrofit.ProductsApi

class ProductPagingSource(val productsApi: ProductsApi) : PagingSource<Int, Product>() {
    override fun getRefreshKey(state: PagingState<Int, Product>): Int? {


        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }



    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {

        try {
            val position = params.key ?: 1
            val response = productsApi.getProducts(position)
            return LoadResult.Page(
                data = response.ProductList,
                prevKey = if (position == 1) null else position -1,
                nextKey = if (position == response.PageInfo.PageCount) null else position + 1

            )

        }
        catch (e : Exception)
        {
            return LoadResult.Error(e)

        }



    }
}