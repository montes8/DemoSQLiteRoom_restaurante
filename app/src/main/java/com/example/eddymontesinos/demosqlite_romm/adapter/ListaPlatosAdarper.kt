package com.example.eddymontesinos.demosqlite_romm.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eddymontesinos.demosqlite_romm.R
import com.example.eddymontesinos.demosqlite_romm.model.Plato
import kotlinx.android.synthetic.main.item_molde_platos.view.*

class ListaPlatosAdarper (val platos :ArrayList<Plato>,val context : Context): RecyclerView.Adapter<ListaPlatosAdarper.PlatosViewHolder>(){



    /*fun addList(user : List<Plato>){
        this.platos = platos

        notifyDataSetChanged()
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlatosViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_molde_platos,parent,false)
        return PlatosViewHolder(view)
    }

    override fun getItemCount(): Int {
        val checkedUser = checkNotNull(platos){return 0}
        return checkedUser.size
    }

    override fun onBindViewHolder(holder: PlatosViewHolder, position: Int) {
        val platos = platos!![position]
        holder.txId.text=platos.idPlato.toString()
        holder.txNombrePlato.text = platos.nombrePlato
        holder.txPrecio.text = platos.precioPlato.toString()

    }

    class PlatosViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        val txId = itemView.text_id
        val txNombrePlato = itemView.text_nombre_plato
        val txPrecio = itemView.text_precio

    }
}