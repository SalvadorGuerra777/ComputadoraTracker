package com.guerra.computadoratracker.data.adapter


import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.guerra.computadoratracker.data.model.ComputerModel
import com.guerra.computadoratracker.databinding.FragmentItemComputerBinding

class ComputerRecyclerViewHolder(private val binding: FragmentItemComputerBinding): RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(
        computer: ComputerModel, clickListener: (ComputerModel)->Unit
    ){
        binding.textViewName.text = computer.modelo
        binding.textViewEmail.text = computer.marca

        binding.cardItem.setOnClickListener{
            clickListener(computer)
        }
    }
    //Si se clickea la carta, se muestra la informacion de esta
}