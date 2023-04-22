package com.asifrezan.apitest.paging

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.asifrezan.apitest.R
import com.asifrezan.apitest.models.Product

class ProductPagingAdapter : PagingDataAdapter<Product, ProductPagingAdapter.ProductViewHolder>(
    COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.product_item,parent,false)
        return ProductViewHolder(view)
    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
       val item = getItem(position)
        if (item != null)
        {
            holder.product_name.text = item.Name
            holder.product_description.text = item.Description
            holder.product_price.text = "$"+item.Price.toString()
            holder.brand_name.text =  if (item.BrandName.isNotEmpty()) "Brand: " + item.BrandName  else ""
            holder.product_size.text = if (item.SizeName.isNotEmpty()) "Size: " + item.SizeName  else ""
            holder.product_color.text = if (item.ColorName.isNotEmpty()) "Color: " + item.ColorName  else ""
        }
    }





    class ProductViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        val product_name = itemview.findViewById<TextView>(R.id.product_name)
        val product_description = itemview.findViewById<TextView>(R.id.product_description)
        val product_price = itemview.findViewById<TextView>(R.id.product_price)
        val brand_name = itemview.findViewById<TextView>(R.id.brand_name)
        val product_size = itemview.findViewById<TextView>(R.id.product_size)
        val product_color = itemview.findViewById<TextView>(R.id.product_color)

    }

    companion object{
        private val COMPARATOR = object : DiffUtil.ItemCallback<Product>(){
            override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem.Id == newItem.Id
            }

            override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem == newItem
            }
        }
    }




}