package meulanche.model

import androidx.recyclerview.widget.DiffUtil

data class EstablishmentModel(
    val id: Int,
    val name: String,
    val category: String,
    val delivery_time: String,
    val delivery_rate: String,
    val state: String
) {
    companion object : DiffUtil.ItemCallback<EstablishmentModel>() {
        override fun areItemsTheSame(
            oldItem: EstablishmentModel,
            newItem: EstablishmentModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: EstablishmentModel,
            newItem: EstablishmentModel
        ): Boolean {
            return oldItem == newItem
        }
    }
}