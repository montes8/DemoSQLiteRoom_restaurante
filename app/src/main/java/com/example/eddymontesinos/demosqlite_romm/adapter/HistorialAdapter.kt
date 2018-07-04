package com.example.eddymontesinos.demosqlite_romm.adapter

import android.os.Handler
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eddymontesinos.demosqlite_romm.R
import com.example.eddymontesinos.demosqlite_romm.model.Pedido
import kotlinx.android.synthetic.main.molde_historial.view.*


class HistorialAdapter(var onDetallePedidoClick: ((Pedido) -> Unit)? = null) : RecyclerView.Adapter<HistorialAdapter.HistorialViewHolder>(){

    private var listaPedidos : List<Pedido>? = null

    fun addList(listaPedidos : List<Pedido>){
        this.listaPedidos = listaPedidos

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistorialViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.molde_historial,parent,false)
        return HistorialViewHolder(view)
    }

    override fun getItemCount(): Int {
        val checkedUser = checkNotNull(listaPedidos){return 0}
        return checkedUser.size
    }

    override fun onBindViewHolder(holder: HistorialViewHolder, position: Int) {
        val pedido = listaPedidos!![position]

            holder.idPedido.text = pedido.idPedido.toString()
            holder.totalPagar.text = pedido.montoTotal.toString()
            holder.fechaPagarPedido.text = pedido.fecha
            holder.itemView.setOnClickListener{

                onDetallePedidoClick?.invoke(pedido)

            }

    }

    class HistorialViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        val idPedido = itemView.id_pedido
        val totalPagar = itemView.total_pagar_pedido
        val fechaPagarPedido = itemView.fecha_pedido

    }
}