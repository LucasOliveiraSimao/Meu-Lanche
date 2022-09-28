package com.lucassimao.meulanche.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.button.MaterialButton
import com.lucassimao.meulanche.R
import com.lucassimao.meulanche.databinding.FragmentOrderDetailsBinding

class OrderDetailsFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentOrderDetailsBinding

    @SuppressLint("MissingInflatedId", "InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOrderDetailsBinding.inflate(inflater, container, false)

        val viewBottomSheet = layoutInflater.inflate(R.layout.bottom_sheet, null)

        val bottomSheetDialog = setupBottomSheetDialog(viewBottomSheet)

        binding.btnContinueOrder.setOnClickListener {

            bottomSheetDialog.show()

            val makePayment = viewBottomSheet.findViewById<MaterialButton>(R.id.btn_make_payment)
            val keepBuying = viewBottomSheet.findViewById<MaterialButton>(R.id.btn_keep_buying)
            val close = viewBottomSheet.findViewById<MaterialButton>(R.id.btn_continue)

            navigateForScreenPayment(makePayment, bottomSheetDialog)
            navigateForScreenProductMenu(keepBuying, bottomSheetDialog)
            closeBottomSheet(close, bottomSheetDialog)

        }

        return binding.root
    }

    private fun setupBottomSheetDialog(viewBottomSheet: View): BottomSheetDialog {
        val bottomSheetDialog = BottomSheetDialog(requireContext())
        bottomSheetDialog.setContentView(viewBottomSheet)
        return bottomSheetDialog
    }

    private fun closeBottomSheet(
        close: MaterialButton,
        bottomSheetDialog: BottomSheetDialog
    ) {
        close.setOnClickListener {
            bottomSheetDialog.dismiss()
        }
    }

    private fun navigateForScreenProductMenu(
        keepBuying: MaterialButton,
        bottomSheetDialog: BottomSheetDialog
    ) {
        keepBuying.setOnClickListener {
            findNavController().navigate(R.id.action_orderDetailsFragment_to_productMenuFragment)
            bottomSheetDialog.dismiss()
        }
    }

    private fun navigateForScreenPayment(
        makePayment: MaterialButton,
        bottomSheetDialog: BottomSheetDialog
    ) {
        makePayment.setOnClickListener {
            findNavController().navigate(R.id.action_orderDetailsFragment_to_paymentFragment)
            bottomSheetDialog.dismiss()
        }
    }

}