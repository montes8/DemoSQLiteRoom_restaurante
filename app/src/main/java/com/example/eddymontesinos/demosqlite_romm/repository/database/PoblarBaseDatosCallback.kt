package com.example.eddymontesinos.demosqlite_romm.repository.database

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.util.Log
import com.example.eddymontesinos.demosqlite_romm.DemoApplication
import com.example.eddymontesinos.demosqlite_romm.R
import com.example.eddymontesinos.demosqlite_romm.model.Plato

class PoblarBaseDatosCallback(val context: Context):  RoomDatabase.Callback(){

    //se ejecuta despues que se hayan creado las tablas.
    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)

        Log.i("db", "onCreate()")
        //poner inserts

        val listaPlatos = ArrayList<Plato>()

        listaPlatos.add(Plato(nombrePlato = "Lomo Saltado", imagen = "lomo",precioPlato =  15.50,calorias = "1200 kl",descuento = 10,descripcion = context.getString(R.string.lomo)))
        listaPlatos.add(Plato(nombrePlato = "Arroz con pollo", imagen = "arroz",precioPlato =  10.50,calorias = "1200 kl",descuento = 10,descripcion = context.getString(R.string.arrozpollo)))
        listaPlatos.add(Plato(nombrePlato = "Ceviche", imagen = "ceviche",precioPlato =  20.50,calorias = "1200 kl",descuento = 10,descripcion = context.getString(R.string.ceviche)))
        listaPlatos.add(Plato(nombrePlato = "Rocoto Relleno", imagen = "rocoto",precioPlato =  17.00,calorias = "1200 kl",descuento = 10,descripcion = context.getString(R.string.rocoto)))
        listaPlatos.add(Plato(nombrePlato = "Aji de Gallina", imagen = "aji",precioPlato =  10.00,calorias = "1200 kl",descuento = 10,descripcion = context.getString(R.string.aji)))
        listaPlatos.add(Plato(nombrePlato = "papa a la Huancaina", imagen = "huancaina",precioPlato =  10.50,calorias = "1200 kl",descuento = 10,descripcion = context.getString(R.string.papahuancaina)))
        listaPlatos.add(Plato(nombrePlato = "Cuy", imagen = "cuy",precioPlato =  25.50,calorias = "1200 kl",descuento = 10,descripcion = context.getString(R.string.cuy)))
        listaPlatos.add(Plato(nombrePlato = "Arroz Chaufa", imagen = "chaufa",precioPlato =  12.00,calorias = "1200 kl",descuento = 10,descripcion = context.getString(R.string.chaufa)))
        listaPlatos.add(Plato(nombrePlato = "Cau Cau", imagen = "caucau",precioPlato =  10.50,calorias = "1200 kl",descuento = 10,descripcion = context.getString(R.string.caucau)))
        listaPlatos.add(Plato(nombrePlato = "Causa", imagen = "causa",precioPlato =  10.00,calorias = "1200 kl",descuento = 10,descripcion = context.getString(R.string.causa)))
        listaPlatos.add(Plato(nombrePlato = "Escabeche", imagen = "escabeche",precioPlato =  13.50,calorias = "1200 kl",descuento = 10,descripcion = context.getString(R.string.escabeche)))


        Thread {
            DemoApplication.database!!.platoDao().insertarListaPlatos(listaPlatos)
        }.start()
    }

}