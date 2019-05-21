package com.example.lab5

class product(nombre: String, num: Int, id: String){
    private var nombre : String = nombre
    private var num : Int = num
    private var id : String = id

    //Metodos auto-generados del objeto
    //TO String
    override fun toString(): String {
        return super.toString()
    }

    //Getters de cada atributo
    fun getNombre(): String{
        return nombre
    }
    fun getNum(): Int{
        return num
    }
    fun getId(): String{
        return id
    }

    //Setters de cada atributo
    fun setNombre(newNombre:String){
        this.nombre = newNombre
    }
    fun setId(newId: String){
        this.id= newId
    }
    fun setNum(newNum: Int){
        this.num = newNum
    }
}