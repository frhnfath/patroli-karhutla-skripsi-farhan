package com.ilmukomputeripb.patrolikarhutla.uifragment.Observasi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ilmukomputeripb.patrolikarhutla.databinding.FragmentPatroliObservasiBinding

class PatroliObservasiFragment : Fragment() {

    private var _binding: FragmentPatroliObservasiBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val patroliObservasiViewModel =
            ViewModelProvider(this).get(PatroliObservasiViewModel::class.java)

        _binding = FragmentPatroliObservasiBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}