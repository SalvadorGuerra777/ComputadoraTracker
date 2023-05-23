package com.guerra.computadoratracker.ui.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.guerra.computadoratracker.data.model.ComputerModel
import com.guerra.hoteltracker.ComputerReviewerApplication
import com.guerra.computadoratracker.repository.Repository
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY

class ComputerViewModel (private val repository: Repository): ViewModel() {
    val marca = MutableLiveData("")
    val modelo = MutableLiveData("")
    val status = MutableLiveData("")

    fun getComputers () = repository.getComputers()

    private fun addComputer(computer: ComputerModel) = repository.setComputer(computer)

    private fun validateData(): Boolean{
        when{
            marca.value.isNullOrBlank() -> return false
            modelo.value.isNullOrBlank() -> return false
        }
        return true
    }

    fun createComputer(): String{
        if(!validateData()){
            status.value = WRONG_INFORMATION
            return WRONG_INFORMATION
        }
        val computer = ComputerModel(
            marca = marca.value!!,
            modelo = modelo.value!!
        )

        addComputer(computer)
        status.value = COMPUTER_ADDED

        return COMPUTER_ADDED
    }

    fun clearData(){
        marca.value = ""
        modelo.value = ""
    }

    fun clearStatus (){
        status.value = INACTIVE
    }

    fun setSelectedComputer(computer: ComputerModel){
        marca.value = computer.marca
        modelo.value = computer.modelo
    }

    companion object{

        val Factory = viewModelFactory {
            initializer {
                val computerRepository = (this[APPLICATION_KEY] as ComputerReviewerApplication).computerRepository
                ComputerViewModel(computerRepository)
            }
        }

        const val COMPUTER_ADDED  = "Computer added to database"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }
}