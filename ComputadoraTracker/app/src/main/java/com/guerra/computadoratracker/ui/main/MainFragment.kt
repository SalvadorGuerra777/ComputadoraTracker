package com.guerra.computadoratracker.ui.main



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.guerra.computadoratracker.data.adapter.ComputerRecyclerViewAdapter
import com.guerra.computadoratracker.data.model.ComputerModel
import com.guerra.computadoratracker.ui.viewmodel.ComputerViewModel
import com.guerra.hoteltracker.R
import com.guerra.hoteltracker.databinding.FragmentMainBinding


/**
Main application view
 */
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: ComputerRecyclerViewAdapter

    private val computerViewModel: ComputerViewModel by activityViewModels{
        ComputerViewModel.Factory
    }
    //ya
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }
    //ya
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                onBackPressed()
            }
        })

        listeners()
        recyclerView(view)
    }
    //ya
    private fun listeners() {
        binding.btnAddComputer.setOnClickListener{
            computerViewModel.clearData()
            it.findNavController().navigate(R.id.action_mainFragment3_to_formFragment)
        }
    }

    private fun showSelectedItem(computer: ComputerModel){
        computerViewModel.setSelectedComputer(computer)
        findNavController().navigate(R.id.action_mainFragment3_to_viewComputerFragment)
    }

    private fun displayComputers(){
        adapter.setData(computerList = computerViewModel.getComputers())
        adapter.notifyDataSetChanged()
    }

    private fun recyclerView(view: View){
        binding.recyleViewComputer.layoutManager = LinearLayoutManager(view.context)

        adapter = ComputerRecyclerViewAdapter { selectedComputer ->
            showSelectedItem(selectedComputer)
        }

        binding.recyleViewComputer.adapter = adapter
        displayComputers()
    }

    //ya
    private fun onBackPressed(){
        val navController = Navigation.findNavController(requireView())
        val toast = Toast.makeText(requireContext(), "works", Toast.LENGTH_SHORT)
        toast.show()
        if(navController.currentDestination?.id != R.id.mainFragment3){
            navController.popBackStack()
        }
        else requireActivity().onBackPressed()
    }
}