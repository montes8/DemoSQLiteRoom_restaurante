package com.example.eddymontesinos.demosqlite_romm.database

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.RoomDatabase
import android.util.Log
import com.example.eddymontesinos.demosqlite_romm.DemoApplication
import com.example.eddymontesinos.demosqlite_romm.model.Plato

class PoblarBaseDatosCallback:  RoomDatabase.Callback(){

    //se ejecuta despues que se hayan creado las tablas.
    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)

        Log.i("db", "onCreate()")
        //poner inserts

        val listaPlatos = ArrayList<Plato>()

        listaPlatos.add(Plato(nombrePlato = "Lomo Saltado", imagen = "lomo_saltado",precioPlato =  15.50))
        listaPlatos.add(Plato(nombrePlato = "Lomo Saltado", imagen = "lomo_saltado",precioPlato =  15.50))
        listaPlatos.add(Plato(nombrePlato = "Lomo Saltado", imagen = "lomo_saltado",precioPlato =  15.50))
        listaPlatos.add(Plato(nombrePlato = "Lomo Saltado", imagen = "lomo_saltado",precioPlato =  15.50))
        listaPlatos.add(Plato(nombrePlato = "Lomo Saltado", imagen = "lomo_saltado",precioPlato =  15.50))
        listaPlatos.add(Plato(nombrePlato = "Lomo Saltado", imagen = "lomo_saltado",precioPlato =  15.50))
        listaPlatos.add(Plato(nombrePlato = "Lomo Saltado", imagen = "lomo_saltado",precioPlato =  15.50))
        listaPlatos.add(Plato(nombrePlato = "Lomo Saltado", imagen = "lomo_saltado",precioPlato =  15.50))
        listaPlatos.add(Plato(nombrePlato = "Lomo Saltado", imagen = "lomo_saltado",precioPlato =  15.50))

        Thread {
            DemoApplication.database!!.platoDao().insertarListaPlatos(listaPlatos)
        }.start()
    }
}