package com.example.eddymontesinos.demosqlite_romm.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eddymontesinos.demosqlite_romm.R
import com.example.eddymontesinos.demosqlite_romm.model.Plato
import kotlinx.android.synthetic.main.item_molde_platos.view.*

class ListaPlatosAdarper : RecyclerView.Adapter<ListaPlatosAdarper.PlatosViewHolder>(){

     private var platos : List<Plato>? = null

    fun addList(platos : List<Plato>){
        this.platos = platos

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlatosViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_molde_platos,parent,false)
        return PlatosViewHolder(view)
    }

    override fun getItemCount(): Int {
        val checkedUser = checkNotNull(platos){return 0}
        return checkedUser.size
    }


    override fun onBindViewHolder(holder: PlatosViewHolder, position: Int) {
        val plato = platos!![position]
        holder.txId.text=plato.idPlato.toString()
        holder.txNombrePlato.text = plato.nombrePlato
        holder.txPrecio.text = "$/ ${plato.precioPlato}"

    }

    class PlatosViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        val txId = itemView.text_id
        val txNombrePlato = itemView.text_nombre_plato
        val txPrecio = itemView.text_precio

    }
}