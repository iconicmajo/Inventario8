package com.example.lab5
import android.app.Application

class Methods: Application() {

    companion object : Contrato{
       override  val inventario: ArrayList<product> = ArrayList()

        override fun vaciar() {
            inventario.clear()
        }

       override fun borrar(pos: Int) {
            inventario.removeAt(pos)
        }

        override fun agregar(newproduct: product) {
            //To change body of created functions use File | Settings | File Templates.
            inventario.add(newproduct)
        }

       override fun showAll(): String{
            var total = "Los productos: "
            for(a: product in inventario)
                total = total + a.getNombre() + ", "
            return total
        }
    }

}