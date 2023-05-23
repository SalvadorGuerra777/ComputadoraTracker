package com.guerra.computadoratracker.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.guerra.computadoratracker.data.model.ComputerModel
import com.guerra.hoteltracker.databinding.FragmentItemComputerBinding

class ComputerRecyclerViewAdapter(
    private val clickListener: (ComputerModel) -> Unit
): RecyclerView.Adapter<ComputerRecyclerViewHolder>() {
    private val computers = ArrayList<ComputerModel>()
    //llenamos la lista con los datos que vienen del modelo

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComputerRecyclerViewHolder {
        val binding = FragmentItemComputerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ComputerRecyclerViewHolder(binding)
    }
    //Se crean las vistas con los datos anteriormente recibidos

    override fun getItemCount() = computers.size

    override fun onBindViewHolder(holder: ComputerRecyclerViewHolder, position: Int) {
        val computer = computers[position]
        holder.bind(computer, clickListener)
    }

    fun setData(computerList: List<ComputerModel>){
        computers.clear()
        computers.addAll(computerList)
    }

}