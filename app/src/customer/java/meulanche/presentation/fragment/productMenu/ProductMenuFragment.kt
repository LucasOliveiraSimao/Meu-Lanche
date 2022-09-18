package meulanche.presentation.fragment.productMenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lucassimao.meulanche.databinding.FragmentProductMenuBinding
import meulanche.model.ProductMenuModel

class ProductMenuFragment : Fragment() {
    private lateinit var binding: FragmentProductMenuBinding
    private lateinit var adapter: ProductMenuAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductMenuBinding.inflate(inflater, container, false)

        setupRecyclerView()

        return binding.root
    }

    private fun setupRecyclerView() {
        adapter = ProductMenuAdapter(onItemClick = {

        })

        binding.rvListProductMenu.adapter = adapter

        adapter.submitList(productMenuList())
    }

    private fun productMenuList(): List<ProductMenuModel> {
            return listOf(
                ProductMenuModel(
                    id = 1,
                    name = "Americano",
                    description = "Pão de forma, 2 ovos, queijo, presunto, tomate e alface",
                    price = "A partir de R$ 10,00"
                ),
                ProductMenuModel(
                    id = 2,
                    name = "Hamburguer",
                    description = "Pão de hamburguer, queijo e presunto",
                    price = "A partir de R$ 7,00"
                ),
                ProductMenuModel(
                    id = 3,
                    name = "Sanduiche bomba calórica",
                    description = "Pão francês, filé, calabresa, bacon, salsicha, requeijão, cebola, tomate e alface",
                    price = "A partir de R$ 11,00"
                )
            )

    }

}