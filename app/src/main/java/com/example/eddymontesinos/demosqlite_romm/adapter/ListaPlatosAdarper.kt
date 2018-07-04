package com.example.eddymontesinos.demosqlite_romm.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eddymontesinos.demosqlite_romm.R
import com.example.eddymontesinos.demosqlite_romm.model.Plato
import com.example.eddymontesinos.demosqlite_romm.utils.DemoUtils
import kotlinx.android.synthetic.main.item_molde_platos.view.*

class ListaPlatosAdarper(val contexto: Context,var onDetalleClick: ((Plato) -> Unit)? = null ,var onAgregarOrdenClick: ((Plato) -> Unit)? = null,var onAgregarCantidadClick: ((Plato) -> Unit)? = null) : RecyclerView.Adapter<ListaPlatosAdarper.PlatosViewHolder>(){

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

        holder.txNombrePlato.text = plato.nombrePlato
        holder.imagePlato.setImageDrawable(DemoUtils.getImage(contexto, plato.imagen))
        holder.txPrecio.text = "$/ ${plato.precioPlato}"
        holder.nextflecha.setOnClickListener{
            onDetalleClick?.invoke(plato)
        }
        holder.addClick.setOnClickListener{
            onAgregarOrdenClick?.invoke(plato)
        }

        holder.itemView.setOnClickListener{

              onAgregarCantidadClick?.invoke(plato)
        }

    }

    class PlatosViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
       val imagePlato = itemView.image_view_plato
        val txNombrePlato = itemView.text_nombre_pletoitem
        val txPrecio = itemView.text_precio
        val nextflecha = itemView.image_detalles
        val addClick = itemView.image_add

    }
}