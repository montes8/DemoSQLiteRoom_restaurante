package com.example.eddymontesinos.demosqlite_romm.adapter

import android.content.Context
import android.os.Handler
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eddymontesinos.demosqlite_romm.DemoApplication
import com.example.eddymontesinos.demosqlite_romm.R
import com.example.eddymontesinos.demosqlite_romm.model.DetallePedido
import com.example.eddymontesinos.demosqlite_romm.utils.DemoUtils
import kotlinx.android.synthetic.main.molde_historial_pedido.view.*

class HistorialPedidoAdarper(val contexto: Context) : RecyclerView.Adapter<HistorialPedidoAdarper.HistorialViewHolder>(){

    private var historialpedidos : List<DetallePedido>? = null
    val handler = Handler()

    fun addList(historialpedidos : List<DetallePedido>){
        this.historialpedidos = historialpedidos

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistorialViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.molde_historial_pedido,parent,false)
        return HistorialViewHolder(view)
    }

    override fun getItemCount(): Int {
        val checkedUser = checkNotNull(historialpedidos){return 0}
        return checkedUser.size
    }

    override fun onBindViewHolder(holder: HistorialViewHolder, position: Int) {
        val pedidoHistorial = historialpedidos!![position]


        Thread {
            val plato = DemoApplication.database!!.detallePedidoDao().detallesDePlato(pedidoHistorial.platoId!!.toLong())
            val pedido = DemoApplication.database!!.detallePedidoDao().detalleDePedido(pedidoHistorial.pedidoId!!.toLong())

            handler.post {
                holder.txNombrePlato.text = plato.nombrePlato
                holder.txPrecio.text = plato.precioPlato.toString()
                holder.imagePlato.setImageDrawable(DemoUtils.getImage(contexto, plato.imagen))
                holder.fechaPedido.text = pedido.fecha
            }
        }.start()



        holder.cantidadPlatos.text = pedidoHistorial.cantidad.toString()
        holder.subtotalPagar.text = pedidoHistorial.subTotal.toString()



    }

    class HistorialViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        val imagePlato = itemView.image_plato_historial
        val txNombrePlato = itemView.nombre_plato_historial
        val txPrecio = itemView.precio_plato_historial
        val cantidadPlatos = itemView.cantidad_platos_historial
        val subtotalPagar = itemView.subtotal_pagar_historial
        val fechaPedido = itemView.fecha_pedido_historial

    }
}