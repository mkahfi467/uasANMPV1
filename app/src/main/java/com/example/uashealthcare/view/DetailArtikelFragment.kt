package com.example.uashealthcare.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.uashealthcare.R
import com.example.uashealthcare.viewmodel.DetailArtikelViewModel
import com.google.android.material.textfield.TextInputEditText

class DetailArtikelFragment : Fragment() {
    private lateinit var viewModel: DetailArtikelViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_artikel, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailArtikelViewModel::class.java)

        val uuid = DetailArtikelFragmentArgs.fromBundle(requireArguments()).uuid
        viewModel.fetch(uuid)

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.artikelLD.observe(viewLifecycleOwner, Observer {
            val txtJudul = view?.findViewById<TextView>(R.id.txtJudulArtikelDetail)
            txtJudul?.setText(it.judul)
            val txtIsi = view?.findViewById<TextView>(R.id.txtIsiArtikelDetail)
            txtIsi?.setText(it.isi)
        })
    }
}