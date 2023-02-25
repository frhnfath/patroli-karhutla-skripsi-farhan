package com.ilmukomputeripb.patrolikarhutla.uifragment.main

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.ilmukomputeripb.patrolikarhutla.R
import com.ilmukomputeripb.patrolikarhutla.databinding.FragmentPatroliUmumBinding
import com.ilmukomputeripb.patrolikarhutla.view.MainActivity
import java.util.*

/**
 * A placeholder fragment containing a simple view.
 */
class PatroliUmumFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel
    private var _binding: FragmentPatroliUmumBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // kategori patroli
    var selectedKategoriPatroliIndex = 0
    private val arrKategoriPatroli = arrayOf("Mandiri", "Rutin", "Terpadu")
    var selectedKategoriPatroli = arrKategoriPatroli[selectedKategoriPatroliIndex]

    // aktivitas harian
    var selectedAktivitasHarianIndex = 0
    private val arrAktivitasHarian = arrayOf("Mandiri", "Rutin", "Terpadu")
    var selectedAktivitasHarian = arrAktivitasHarian[selectedAktivitasHarianIndex]

    // anggota patroli
    var selectedAnggotaPatroliIndex = 0
    private val arrAnggotaPatroli = arrayOf("Mandiri", "Rutin", "Terpadu")
    var selectedAnggotaPatroli = arrAnggotaPatroli[selectedAnggotaPatroliIndex]

    // inventori patroli
    var selectedInventoriPatroliIndex = 0
    private val arrInventoriPatroli = arrayOf("Mandiri", "Rutin", "Terpadu")
    var selectedInventoriPatroli = arrInventoriPatroli[selectedInventoriPatroliIndex]

    // inventori patroli
    var selectedSatelitIndex = 0
    private val arrSatelit = arrayOf("Mandiri", "Rutin", "Terpadu")
    var selectedSatelit = arrSatelit[selectedSatelitIndex]

    // Image
    var selectedDocumentationIndex = 0
    private val arrDocumentation = arrayOf("Load from Library", "Use Camera")
    var selectedDocumentation = arrDocumentation[selectedDocumentationIndex]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        alertDialog(binding.inputKategoriPatroli, R.string.kategori_patroli, arrKategoriPatroli, selectedKategoriPatroliIndex, selectedKategoriPatroli)
        alertDialog(binding.inputAktivitasHarian, R.string.aktivitas_harian, arrAktivitasHarian, selectedAktivitasHarianIndex, selectedAktivitasHarian)
        alertDialog(binding.inputAnggotaPatroli, R.string.anggota_patroli, arrAnggotaPatroli, selectedAnggotaPatroliIndex, selectedAnggotaPatroli)
        alertDialog(binding.inputInventoriPatroli, R.string.inventori_patroli, arrInventoriPatroli, selectedInventoriPatroliIndex, selectedInventoriPatroli)
        alertDialog(binding.inputSatelitHotspot, R.string.satelit_hotspot, arrSatelit, selectedSatelitIndex, selectedSatelit)
        alertDocumentation()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPatroliUmumBinding.inflate(inflater, container, false)
        val root = binding.root

        pageViewModel.text.observe(viewLifecycleOwner, Observer {

        })
        return root
    }

    private fun alertDocumentation() {
        binding.btnUploadDocumentation.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Select Image Source")
                .setSingleChoiceItems(arrDocumentation, selectedDocumentationIndex) {dialog, which ->
                    selectedDocumentationIndex = which
                    selectedDocumentation = arrDocumentation[which]
                }
                .setPositiveButton("OK") {dialog, which ->
                    when(selectedDocumentationIndex) {
                        0 -> Snackbar.make(it, selectedDocumentation, Snackbar.LENGTH_SHORT).show()
                        1 -> Snackbar.make(it, selectedDocumentation, Snackbar.LENGTH_SHORT).show()
                    }
                }
                .setNeutralButton("Cancel") {dialog, which ->

                }
                .show()
        }
    }

    private fun alertDialog(view: AutoCompleteTextView, title: Int, items: Array<String>, selectedIndex: Int, selected: String) {
        var _selectedIndex = selectedIndex
        var _selected = selected
        view.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(title)
                .setSingleChoiceItems(items, selectedIndex) {dialog, which ->
                    _selectedIndex = which
                    _selected = arrKategoriPatroli[which]
                }
                .setPositiveButton("OK") {dialog, which ->
                    Snackbar.make(it, "$_selected Selected", Snackbar.LENGTH_SHORT).show()
                    view.setText(_selected)
                }
                .setNeutralButton("Cancel") {dialog, which ->

                }
                .show()
        }
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"
        const val CAMERA_RESULT = 200
        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): PatroliUmumFragment {
            return PatroliUmumFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}