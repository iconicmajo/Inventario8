package com.example.lab5

interface Contrato {

    //Crea el nuevo producto
    val inventario: ArrayList<product>

    //implementacion de los metodos
    fun borrar(pos: Int)
    fun vaciar()
    fun agregar(newproduct: product)
    fun showAll():String
}