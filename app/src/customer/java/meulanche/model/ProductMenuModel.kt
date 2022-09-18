package meulanche.model

import androidx.recyclerview.widget.DiffUtil

data class ProductMenuModel(
    val id: Int,
    val name: String,
    val description: String,
    val price: String
) {
    companion object : DiffUtil.ItemCallback<ProductMenuModel>() {
        override fun areItemsTheSame(
            oldItem: ProductMenuModel,
            newItem: ProductMenuModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ProductMenuModel,
            newItem: ProductMenuModel
        ): Boolean {
            return oldItem == newItem
        }
    }
}