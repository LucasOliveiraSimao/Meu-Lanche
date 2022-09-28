package com.lucassimao.meulanche.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.lucassimao.meulanche.R
import com.lucassimao.meulanche.databinding.FragmentHomeBinding
import com.lucassimao.meulanche.model.EstablishmentModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: EstablishmentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        setupRecyclerView()

        return binding.root
    }

    private fun setupRecyclerView() {
        adapter = EstablishmentAdapter(onItemClick = {
            findNavController().navigate(R.id.action_homeFragment_to_productMenuFragment)
        })

        binding.rvListEstablishment.adapter = adapter

        adapter.submitList(establishmentList())
    }

    private fun establishmentList(): List<EstablishmentModel> {
        return listOf(
            EstablishmentModel(
                id = 1,
                name = "Kablocos Burguer",
                category = "Hamburgueria, Lanchonete",
                delivery_time = "30-40 min",
                delivery_rate = "R$ 4,00 a 8,00",
                state = "Fechado"
            ),
            EstablishmentModel(
                id = 2,
                name = "Villa Food Park Ita",
                category = "Pizzaria, Hamburgueria",
                delivery_time = "50-60 min",
                delivery_rate = "R$ 4,00 a 8,00",
                state = "Aberto"
            ),
            EstablishmentModel(
                id = 3,
                name = "Bobs",
                category = "Hamburgueria, Lanchonete",
                delivery_time = "25-35 min",
                delivery_rate = "R$ 4,00 a 8,00",
                state = "Fechado"
            ),
            EstablishmentModel(
                id = 4,
                name = "Ponto do Guarana",
                category = "Hamburgueria, Pizzaria",
                delivery_time = "40-50 min",
                delivery_rate = "R$ 4,00 a 8,00",
                state = "Aberto"
            ),
            EstablishmentModel(
                id = 5,
                name = "Corujas Lanche",
                category = "Hamburgueria, Lanchonete",
                delivery_time = "30-40 min",
                delivery_rate = "Não Fazemos Entrega",
                state = "Aberto"
            ),
        )
    }

}