package com.guerra.computadoratracker.data.model



//computadora 1
const val modelo  ="Lenovo"
const val marca  ="Thinkpad"


//computadora 2
const val modelo2  ="HP"
const val marca2  ="1DOFSTL"


var computers = mutableListOf(
    ComputerModel(modelo, marca),
    ComputerModel( modelo2, marca2),
    ComputerModel( modelo2, marca)
)
//Data quemada y estatica que nos sirve para el ejemplo