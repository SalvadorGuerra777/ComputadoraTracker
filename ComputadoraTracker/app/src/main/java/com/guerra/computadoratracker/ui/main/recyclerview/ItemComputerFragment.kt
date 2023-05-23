package com.guerra.computadoratracker.ui.main.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.guerra.computadoratracker.databinding.FragmentItemComputerBinding


class ItemComputerFragment : Fragment() {

    private lateinit var binding: FragmentItemComputerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    //Biding se encarga de crear el nuevo componente a partir de uno ya creado y lo implementa a la vista general
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemComputerBinding.inflate(inflater, container, false)
        return binding.root
    }

}