package com.example.uashealthcare.view

import android.os.Bundle
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
//            val txtTitle = view.findViewById<EditText>(R.id.txtTitle)
//            val txtNotes = view.findViewById<EditText>(R.id.txtNotes)

            // CARA CEPAT UNTUK MENDAPATKAN RADIO YANG TERPILIH
//            val radioGroup = view.findViewById<RadioGroup>(R.id.rdoGroupPriority)
//            val radioButton = view.findViewById<RadioButton>(radioGroup.checkedRadioButtonId)

//            var todo = Artikel(txtTitle.text.toString(), txtNotes.text.toString(), radioButton.tag.toString().toInt())
            val artikel = Artikel("AAA", "BBB", "CCC")

            viewModel.addArtikel(artikel)

            Toast.makeText(view.context, "Data added", Toast.LENGTH_LONG).show()
            Navigation.findNavController(it).popBackStack()
        }
    }
}