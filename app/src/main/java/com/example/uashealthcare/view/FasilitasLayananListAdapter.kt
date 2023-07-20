package com.example.uashealthcare.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uashealthcare.R
import com.example.uashealthcare.model.Artikel
import com.example.uashealthcare.model.Fasilitas


class FasilitasLayananListAdapter(val fasilitasLayananList:ArrayList<Fasilitas>, val adapterOnClick : (Fasilitas) -> Unit)
    :RecyclerView.Adapter<FasilitasLayananListAdapter.FasilitasLayananViewHolder>()
{
    class FasilitasLayananViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FasilitasLayananViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.fasilitaslayanan_list_item, parent, false)
        return FasilitasLayananViewHolder(view)
    }

    override fun onBindViewHolder(holder:FasilitasLayananViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return fasilitasLayananList.size
    }
    fun updateFasilitasLayananList(newFasilitasLayananList: ArrayList<Fasilitas>) {
        fasilitasLayananList.clear()
        fasilitasLayananList.addAll(newFasilitasLayananList)
        notifyDataSetChanged()
    }
}