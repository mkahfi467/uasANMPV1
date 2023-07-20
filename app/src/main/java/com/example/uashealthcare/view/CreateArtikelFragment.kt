package com.example.uashealthcare.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.uashealthcare.R
import com.example.uashealthcare.model.Artikel
import com.example.uashealthcare.viewmodel.DetailArtikelViewModel
import com.google.android.material.textfield.TextInputEditText

class CreateArtikelFragment : Fragment() {
    private lateinit var viewModel: DetailArtikelViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_artikel, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailArtikelViewModel::class.java)

        val btnAdd = view.findViewById<Button>(R.id.btnAdd)
        btnAdd.setOnClickListener {
            val judul = view.findViewById<EditText>(R.id.txtInputJudulArtikel)
            val isi = view.findViewById<EditText>(R.id.txtInputIsiArtikel)
            val urlFoto = view.findViewById<EditText>(R.id.txtInputFotoArtikel)

            val artikel = Artikel(judul.text.toString(), isi.text.toString(), urlFoto.text.toString())

            viewModel.addArtikel(artikel)

            Toast.makeText(view.context, "Artikel berhasil dibuat", Toast.LENGTH_LONG).show()
            Navigation.findNavController(it).popBackStack()
        }
    }
}