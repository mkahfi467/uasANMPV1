package com.example.uashealthcare.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.uashealthcare.databinding.ArtikelItemLayoutBinding
import com.example.uashealthcare.model.Artikel

class ArtikelListAdapter(val artikelList:ArrayList<Artikel>, val adapterOnClick : (Artikel) -> Unit)
    : RecyclerView.Adapter<ArtikelListAdapter.ArtikelViewHolder>(), ArtikelItemLayoutInterface{

    class ArtikelViewHolder(var view: ArtikelItemLayoutBinding): RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtikelViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = ArtikelItemLayoutBinding.inflate(inflater, parent, false)
        return ArtikelViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArtikelViewHolder, position: Int) {
        holder.view.artikel = artikelList[position]
//        holder.view.checklistener = this
//        holder.view.editListener = this
    }
    override fun getItemCount(): Int {
        return artikelList.size
    }

    fun updateArtikelList(newArtikelList: List<Artikel>) {
        artikelList.clear()
        artikelList.addAll(newArtikelList)
        notifyDataSetChanged()
    }

//    override fun onCheckedChange(cb: CompoundButton, isChecked: Boolean, obj: Artikel) {
//        if(isChecked) {
//            adapterOnClick(obj)
//        }
//    }

//    override fun onTodoEditClick(v: View) {
//        val action = TodoListFragmentDirections.actionEditTodoFragment(v.tag.toString().toInt())
//        Navigation.findNavController(v).navigate(action)
//    }
}