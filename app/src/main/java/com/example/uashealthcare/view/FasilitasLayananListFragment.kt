package com.example.uashealthcare.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uashealthcare.R
import com.example.uashealthcare.viewmodel.ListArtikelViewModel
import com.example.uashealthcare.viewmodel.ListFasilitasLayananViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class FasilitasLayananListFragment : Fragment() {
    private lateinit var viewModel:ListFasilitasLayananViewModel
    private val FasilitasLayananListAdapter  = FasilitasLayananListAdapter(arrayListOf(), { item -> viewModel.clearTask(item) })
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fasilitas_layanan_list, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListFasilitasLayananViewModel::class.java)
        viewModel.refresh()

        var recViewFasilitas = view.findViewById<RecyclerView>(R.id.recViewFasilitasLayanan)
        recViewFasilitas.layoutManager = LinearLayoutManager(context)
        recViewFasilitas.adapter = FasilitasLayananListAdapter

        observeViewModel()
    }
    fun observeViewModel() {
        viewModel.FasilitasLayananLD.observe(viewLifecycleOwner, Observer {
            FasilitasLayananListAdapter.updateFasilitasLayananList(it)
        })
    }
}