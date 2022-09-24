package com.lucassimao.meulanche.model

import androidx.recyclerview.widget.DiffUtil

data class ProductModel(
    val id: Int,
    val name: String,
    val description: String,
    val price: String
) {
    companion object : DiffUtil.ItemCallback<ProductModel>() {
        override fun areItemsTheSame(
            oldItem: ProductModel,
            newItem: ProductModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ProductModel,
            newItem: ProductModel
        ): Boolean {
            return oldItem == newItem
        }
    }
}