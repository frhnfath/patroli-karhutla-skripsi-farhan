package com.ilmukomputeripb.patrolikarhutla.uifragment.Darat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.ilmukomputeripb.patrolikarhutla.R
import com.ilmukomputeripb.patrolikarhutla.databinding.FragmentPatroliDaratBinding

class PatroliDaratFragment : Fragment() {

    private var _binding: FragmentPatroliDaratBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val patroliDaratViewModel =
            ViewModelProvider(this).get(PatroliDaratViewModel::class.java)

        _binding = FragmentPatroliDaratBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAddPatroliData.setOnClickListener {
            binding.btnLayout.visibility = View.GONE
            binding.formLayout.visibility = View.VISIBLE
        }
        binding.btnFfmcKkas.setOnClickListener { alertDescription(R.string.ffmc_kkas, 1) }
        binding.btnFwiIck.setOnClickListener { alertDescription(R.string.fwi_ick, 2) }
        binding.btnDcKk.setOnClickListener { alertDescription(R.string.dc_kk, 3) }
    }

    private fun alertDescription(title: Int, text: Int) {
        val titleString = getString(title)
        val message = resources.getStringArray(R.array.description)
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(titleString)
            .setMessage(message[text])
            .setPositiveButton("OK") {dialog, which ->

            }
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}