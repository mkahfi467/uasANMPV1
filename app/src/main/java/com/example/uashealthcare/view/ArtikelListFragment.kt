package com.example.uashealthcare.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uashealthcare.R
import com.example.uashealthcare.viewmodel.ListArtikelViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ArtikelListFragment : Fragment() {
    private lateinit var viewModel: ListArtikelViewModel
    private val artikelListAdapter = ArtikelListAdapter(arrayListOf(), { item -> viewModel.clearTask(item) })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_artikel_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListArtikelViewModel::class.java)
        viewModel.refresh()

        var recViewArtikel = view.findViewById<RecyclerView>(R.id.recViewArtikel)
        recViewArtikel.layoutManager = LinearLayoutManager(context)
        recViewArtikel.adapter = artikelListAdapter

        var fabAddArtikel = view.findViewById<FloatingActionButton>(R.id.fabAddArtikel)

        fabAddArtikel.setOnClickListener {
            val action = ArtikelListFragmentDirections.actionCreateArtikel()
            Navigation.findNavController(it).navigate(action)
        }

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.artikelLD.observe(viewLifecycleOwner, Observer {
            artikelListAdapter.updateArtikelList(it)
//            var txtEmpty = view?.findViewById<TextView>(R.id.txtEmpty)
//            if(it.isEmpty()) {
//                txtEmpty?.visibility = View.VISIBLE
//            } else {
//                txtEmpty?.visibility = View.GONE
//            }
        })
    }
}