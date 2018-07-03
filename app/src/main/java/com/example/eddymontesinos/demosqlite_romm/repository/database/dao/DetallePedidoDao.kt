package com.example.eddymontesinos.demosqlite_romm.repository.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.eddymontesinos.demosqlite_romm.model.DetallePedido
import com.example.eddymontesinos.demosqlite_romm.model.Pedido
import com.example.eddymontesinos.demosqlite_romm.model.Plato

@Dao
interface DetallePedidoDao {

    @Query("select * from DetallePedido")
    fun litarDetallePedido(): List<DetallePedido>

    @Query("select * from DetallePedido inner join  Pedido on  DetallePedido.pedidoId=Pedido.idPedido where DetallePedido.pedidoId= :pedidoId")
    fun detalleDePedido(pedidoId: Long): Pedido

    @Query("select * from DetallePedido inner join  Plato on DetallePedido.platoId=Plato.idPlato  where DetallePedido.platoId= :platoId")
    fun detallesDePlato(platoId : Long):Plato

    @Insert
    fun insertarDetallesListaPedido(detalle : ArrayList<DetallePedido>) : Array<Long>

    @Insert
    fun insertDetallePedido(detalle: DetallePedido): Long

    @Delete
    fun deleteDetallePedido(detalle: DetallePedido):Int


}