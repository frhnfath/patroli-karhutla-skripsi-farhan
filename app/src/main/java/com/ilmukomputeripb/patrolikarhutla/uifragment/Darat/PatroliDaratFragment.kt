package com.ilmukomputeripb.patrolikarhutla.uifragment.Darat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}