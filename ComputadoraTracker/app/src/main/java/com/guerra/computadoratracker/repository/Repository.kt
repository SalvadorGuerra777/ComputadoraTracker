package com.guerra.computadoratracker.repository

import com.guerra.computadoratracker.data.model.ComputerModel

class Repository (private val computers: MutableList<ComputerModel>) {
    fun getComputers () = computers

    fun setComputer(computer: ComputerModel) = computers.add(computer)
}
//Primero se obtiene los empleados de la lista mutable que proviene del Model y luego se guardan en employess
//Para mantenerse en el repositorio y jugar con la data