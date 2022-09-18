package meulanche.presentation.fragment.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lucassimao.meulanche.databinding.ItemEstablishmentBinding
import meulanche.model.EstablishmentModel

class EstablishmentAdapter(
    private val onItemClick: (EstablishmentModel) -> Unit,
) :
    ListAdapter<EstablishmentModel, EstablishmentViewHolder>(EstablishmentModel) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EstablishmentViewHolder {
        return EstablishmentViewHolder.from(parent, onItemClick)
    }

    override fun onBindViewHolder(holder: EstablishmentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class EstablishmentViewHolder(
    private val binding: ItemEstablishmentBinding,
    private val onItemClick: (EstablishmentModel) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: EstablishmentModel) {
        binding.apply {
            tvNameEstablishment.text = item.name
            tvCategory.text = item.category
            tvDeliveryTime.text = item.delivery_time
            tvDeliveryRate.text = item.delivery_rate
            tvState.text = item.state

            itemView.setOnClickListener {
                onItemClick(item)
            }
        }
    }

    companion object {
        fun from(
            parent: ViewGroup,
            onItemClick: (EstablishmentModel) -> Unit
        ): EstablishmentViewHolder {
            return EstablishmentViewHolder(
                ItemEstablishmentBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ),
                onItemClick
            )
        }
    }
}