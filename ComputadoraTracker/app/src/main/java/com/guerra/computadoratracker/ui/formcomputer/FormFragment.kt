package com.guerra.computadoratracker.ui.formcomputer


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.guerra.computadoratracker.ui.viewmodel.ComputerViewModel
import com.guerra.computadoratracker.databinding.FragmentFormBinding


class FormFragment : Fragment() {
    private lateinit var binding: FragmentFormBinding
    private val computerViewModel: ComputerViewModel by activityViewModels<ComputerViewModel> {
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
        binding = FragmentFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        sentStatus()
    }

    private fun setViewModel(){
        binding.viewmodel = computerViewModel
    }
    //el binding se encarga de trasladar la data nueva al ViewModel
    private fun sentStatus(){
        computerViewModel.status.observe(viewLifecycleOwner){
            when{
                it.equals(ComputerViewModel.WRONG_INFORMATION)->{
                    val toast = Toast.makeText(requireContext(), ComputerViewModel.WRONG_INFORMATION, Toast.LENGTH_SHORT)
                    toast.show()
                }
                it.equals(ComputerViewModel.COMPUTER_ADDED)->{
                    val toast = Toast.makeText(requireContext(), ComputerViewModel.COMPUTER_ADDED, Toast.LENGTH_SHORT)
                    toast.show()

                    computerViewModel.clearStatus()
                    findNavController().popBackStack()
                }
                //Administracion de estados de informacion que indican de que manera se encuentra la aplicacion en ese momento
            }
        }
    }

}