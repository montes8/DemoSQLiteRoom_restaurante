package com.example.eddymontesinos.demosqlite_romm.repository.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.eddymontesinos.demosqlite_romm.model.*
import com.example.eddymontesinos.demosqlite_romm.repository.database.dao.*

@Database(entities = [Usuario::class,Categoria::class,Plato::class,Pedido::class,DetallePedido::class],version = 1)
abstract class DemoDataBase : RoomDatabase(){

    abstract fun usuarioDao() : UsuarioDao
    abstract fun platoDao() : PlatoDao
    abstract fun pedidoDao() : PedidoDao
    abstract fun detallePedidoDao() : DetallePedidoDao
    abstract fun categoriaDao() : CategoriaDao
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