package com.guerra.computadoratracker.ui.viewcomputer


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.guerra.computadoratracker.ui.viewmodel.ComputerViewModel
import com.guerra.hoteltracker.databinding.FragmentViewComputerBinding


class ViewComputerFragment : Fragment() {

    private lateinit var binding: FragmentViewComputerBinding
    private val computerViewModel:ComputerViewModel by activityViewModels{
        ComputerViewModel.Factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentViewComputerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
    }
    private fun setViewModel(){
            binding.viewmodel = computerViewModel
    }

}