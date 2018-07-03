package com.example.eddymontesinos.demosqlite_romm.repository.temporal


import com.example.eddymontesinos.demosqlite_romm.model.DetalleTemporal

object OrdenTemporal {

    private val orden = ArrayList<DetalleTemporal>()

    fun agregarItemOrden(detallePedido: DetalleTemporal){
        orden.add(detallePedido)
    }

    fun obtenerOrden(): ArrayList<DetalleTemporal>{
        return orden
    }
}