package meulanche.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lucassimao.meulanche.databinding.ItemEstablishmentBinding
import meulanche.model.EstablishmentModel

class EstablishmentAdapter() :
    ListAdapter<EstablishmentModel, EstablishmentViewHolder>(EstablishmentModel) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EstablishmentViewHolder {
        return EstablishmentViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: EstablishmentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class EstablishmentViewHolder(
    private val binding: ItemEstablishmentBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: EstablishmentModel) {
        binding.apply {
            tvNameEstablishment.text = item.name
            tvCategory.text = item.category
            tvDeliveryTime.text = item.delivery_time
            tvDeliveryRate.text = item.delivery_rate
            tvState.text = item.state
        }
    }

    companion object {
        fun from(parent: ViewGroup): EstablishmentViewHolder {
            return EstablishmentViewHolder(
                ItemEstablishmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }
}