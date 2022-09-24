package com.lucassimao.meulanche.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lucassimao.meulanche.databinding.ItemProductBinding
import com.lucassimao.meulanche.model.ProductModel

class ProductAdapter() :
    ListAdapter<ProductModel, ProductViewHolder>(ProductModel) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class ProductViewHolder(
    private val binding: ItemProductBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ProductModel) {
        binding.apply {
            tvNameProduct.text = item.name
            tvDescription.text = item.description
            tvPriceProduct.text = item.price
        }
    }

    companion object {
        fun from(parent: ViewGroup): ProductViewHolder {
            return ProductViewHolder(
                ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }
}