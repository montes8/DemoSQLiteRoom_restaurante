package com.example.eddymontesinos.demosqlite_romm.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.eddymontesinos.demosqlite_romm.database.dao.PlatoDao
import com.example.eddymontesinos.demosqlite_romm.database.dao.UsuarioDao
import com.example.eddymontesinos.demosqlite_romm.model.Plato
import com.example.eddymontesinos.demosqlite_romm.model.Usuario

@Database(entities = [Usuario::class,Plato::class],version = 1)
abstract class DemoDataBase : RoomDatabase(){

    abstract fun usuarioDao() : UsuarioDao
    abstract fun platoDao() : PlatoDao
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