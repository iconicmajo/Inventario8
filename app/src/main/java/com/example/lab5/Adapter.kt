package com.example.lab5

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Button
import android.widget.TextView


//Esta clase fue extraida y modificada de: loopwiki.com
// https://github.com/sooshin/android-inventory-app
// https://www.youtube.com/watch?v=SD2t75T5RdY

class Adapter(//Declare List of Recyclerview Items
    private val recyclerViewItems: List<product>, internal var mContext: Context
) : RecyclerView.Adapter<*>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val row: View
        //Check fot view Type inflate layout according to it
        return RecyclerView.ViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val recyclerViewItem = recyclerViewItems[position]
        //Check holder instance to populate data  according to it
        holder.texViewNombre.text = recyclerViewItem.getNombre()
        holder.num.text = recyclerViewItem.getNum()
        holder.sumar.setOnClickListener{
            var cant = recyclerViewItem.getNum() +1
            recyclerViewItem.setNum(cant)
            holder.num.text = recyclerViewItem.getNum().toString()
        }
        holder.restar.setOnClickListener{
            var cant = recyclerViewItem.getNum() -1
            if(cant>=0){
                recyclerViewItem.setNum(cant)
            }
            else{
                cant = 0
            }
            holder.num.text = recyclerViewItem.getNum().toString()
        }

    }
    //obtener el valor
    override fun getItemCount(): Int {
        return recyclerViewItems.size
    }
    fun deleteProduct(viewHolder: RecyclerView.ViewHolder){
        recyclerViewItems.removeAt(viewHolder.adapterPosition)
        notifyItemRemoved(viewHolder.adapterPosition)
        notifyDataSetChanged()
    }
    fun deleteAll(){
        recyclerViewItems.clear()
    }

    //header holder
    class HeaderHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var texViewNombre: TextView
        internal var textViewCantidad: TextView
        internal var buttonSumar: Button
        internal var buttonResta: Button

        init {
            texViewNombre = itemView.findViewById(R.id.textView_nombre)
            textViewCantidad = itemView.findViewById(R.id.textViewCantidad)
            buttonSumar = itemView.findViewById(R.id.imageViewHeader)
            buttonResta = itemView.findViewById(R.id.imageViewHeader)
        }
        override fun onClick(v: View?) {}
    }
}

