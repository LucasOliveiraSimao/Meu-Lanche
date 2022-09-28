package com.lucassimao.meulanche.presentation.productMenu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lucassimao.meulanche.databinding.ItemProductMenuBinding
import com.lucassimao.meulanche.model.ProductMenuModel

class ProductMenuAdapter(
    private val onItemClick: (ProductMenuModel) -> Unit,
) :
    ListAdapter<ProductMenuModel, ProductMenuViewHolder>(ProductMenuModel) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductMenuViewHolder {
        return ProductMenuViewHolder.from(parent, onItemClick)
    }

    override fun onBindViewHolder(holder: ProductMenuViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class ProductMenuViewHolder(
    private val binding: ItemProductMenuBinding,
    private val onItemClick: (ProductMenuModel) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ProductMenuModel) {
        binding.apply {
            tvNameProduct.text = item.name
            tvDescription.text = item.description
            tvPriceProduct.text = item.price
        }

        itemView.setOnClickListener {
            onItemClick(item)
        }
    }

    companion object {
        fun from(
            parent: ViewGroup,
            onItemClick: (ProductMenuModel) -> Unit
        ): ProductMenuViewHolder {
            return ProductMenuViewHolder(
                ItemProductMenuBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ),
                onItemClick
            )
        }
    }
}