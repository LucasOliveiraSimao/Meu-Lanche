package com.lucassimao.meulanche.presentation.fragment

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.lucassimao.meulanche.R

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        delayer()

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    private fun delayer() {
        Handler().postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
            findNavController().popBackStack()
        }, 2000)
    }

}