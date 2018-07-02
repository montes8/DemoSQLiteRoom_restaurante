package com.example.eddymontesinos.demosqlite_romm.repository.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.eddymontesinos.demosqlite_romm.repository.database.dao.DetallePedidoDao
import com.example.eddymontesinos.demosqlite_romm.repository.database.dao.PedidoDao
import com.example.eddymontesinos.demosqlite_romm.repository.database.dao.PlatoDao
import com.example.eddymontesinos.demosqlite_romm.repository.database.dao.UsuarioDao
import com.example.eddymontesinos.demosqlite_romm.model.DetallePedido
import com.example.eddymontesinos.demosqlite_romm.model.Pedido
import com.example.eddymontesinos.demosqlite_romm.model.Plato
import com.example.eddymontesinos.demosqlite_romm.model.Usuario

@Database(entities = [Usuario::class,Plato::class,Pedido::class,DetallePedido::class],version = 1)
abstract class DemoDataBase : RoomDatabase(){

    abstract fun usuarioDao() : UsuarioDao
    abstract fun platoDao() : PlatoDao
    abstract fun pedidoDao() : PedidoDao
    abstract fun detallePedidoDao() : DetallePedidoDao
/*
    companion object {

        private var INSTANCE: DemoDataBase? = null

        fun getInstance(context: Context): DemoDataBase {
            if(INSTANCE == null){
                //INSTANCE = buildDatabase(context)
            }
            return INSTANCE!!
        }

        fun buildDatabase(context: Context): DemoDataBase {
            return
        }
    }
*/
}