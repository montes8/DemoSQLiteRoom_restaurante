package com.example.eddymontesinos.demosqlite_romm.repository.temporal


import com.example.eddymontesinos.demosqlite_romm.model.DetalleTemporal
import com.example.eddymontesinos.demosqlite_romm.model.Plato

object OrdenTemporal {

    private val orden = ArrayList<DetalleTemporal>()

    fun agregarItemOrden(detallePedido: DetalleTemporal){
        orden.add(detallePedido)
    }

    fun obtenerOrden(): ArrayList<DetalleTemporal>{
        return orden
    }

    fun eliminarOrden(detallePedido: DetalleTemporal){
        orden.remove(detallePedido)
    }

    fun buscarPlato(plato: Plato): Int {
        orden.forEachIndexed { index, detalleTemporal ->
            if(detalleTemporal.plato.idPlato == plato.idPlato){
                return index
            }
        }
        return -1
    }

    fun obtenerCantidadPlatoSegunIndice(indice: Int): Int{
        return orden[indice].cantidad
    }

    fun actualizarItemOrden(ordenItem: DetalleTemporal, indice: Int){
        orden[indice] = ordenItem
    }

    fun limpiarOrden(){
        orden.clear()
    }
}