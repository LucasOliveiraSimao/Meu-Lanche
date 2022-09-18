package meulanche.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lucassimao.meulanche.databinding.FragmentHomeBinding
import meulanche.model.ProductModel
import meulanche.presentation.ProductAdapter

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        setupRecyclerView()

        return binding.root
    }

    private fun setupRecyclerView() {
        adapter = ProductAdapter()

        binding.rvListProduct.adapter = adapter

        adapter.submitList(productsList())
    }

    private fun productsList(): List<ProductModel> {
        return listOf(
            ProductModel(
                id = 1,
                name = "Americano",
                description = "Pão de forma, 2 ovos, queijo, presunto, tomate e alface",
                price = "A partir de R$ 10,00"
            ),
            ProductModel(
                id = 2,
                name = "Hamburguer",
                description = "Pão de hamburguer, queijo e presunto",
                price = "A partir de R$ 7,00"
            ),
            ProductModel(
                id = 3,
                name = "Sanduiche bomba calórica",
                description = "Pão francês, filé, calabresa, bacon, salsicha, requeijão, cebola, tomate e alface",
                price = "A partir de R$ 11,00"
            )
        )
    }

}