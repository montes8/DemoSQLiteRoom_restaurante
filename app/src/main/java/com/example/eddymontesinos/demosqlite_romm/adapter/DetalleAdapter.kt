package com.example.eddymontesinos.demosqlite_romm.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eddymontesinos.demosqlite_romm.R
import com.example.eddymontesinos.demosqlite_romm.model.DetalleTemporal
import com.example.eddymontesinos.demosqlite_romm.utils.DemoUtils
import kotlinx.android.synthetic.main.molde_detalle_pedido.view.*

class DetalleAdapter(val contexto: Context) : RecyclerView.Adapter<DetalleAdapter.DetalleTemporalViewHolder>(){

    private var detalleaTemporal : List<DetalleTemporal>? = null

    fun addList(detalleaTemporal : List<DetalleTemporal>){

        this.detalleaTemporal = detalleaTemporal
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetalleTemporalViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.molde_detalle_pedido,parent,false)
        return DetalleTemporalViewHolder(view)
    }

    override fun getItemCount(): Int {
        val checkedUser = checkNotNull(detalleaTemporal){return 0}
        return checkedUser.size
    }

    override fun onBindViewHolder(holder: DetalleTemporalViewHolder, position: Int) {
        val detallePedido = detalleaTemporal!![position]

        val subtotal = detallePedido.plato.precioPlato * detallePedido.cantidad

       holder.imagenDetalle.setImageDrawable(DemoUtils.getImage(contexto, detallePedido.plato.imagen))
        holder.idPlatoDetalleNombre.text = detallePedido.plato.nombrePlato
        holder.precioPlatounidad.text = detallePedido.plato.precioPlato.toString()
        holder.catidad.text = detallePedido.cantidad.toString()
        holder.subtotal.text = subtotal.toString()
    }

    class DetalleTemporalViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){


        val imagenDetalle = itemView.image_view_plato_detalle
        val idPlatoDetalleNombre = itemView.text_id_platodetalle
        val precioPlatounidad = itemView.text_precio_unitario
        val catidad = itemView.text_cantidad_platos
        val subtotal = itemView.text_subtotal_detalle
    }
}