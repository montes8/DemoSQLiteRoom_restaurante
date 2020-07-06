package com.example.eddymontesinos.demosqlite_romm.repository.database

import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.room.RoomDatabase
import android.content.Context
import android.util.Log
import com.example.eddymontesinos.demosqlite_romm.DemoApplication
import com.example.eddymontesinos.demosqlite_romm.R
import com.example.eddymontesinos.demosqlite_romm.model.Categoria
import com.example.eddymontesinos.demosqlite_romm.model.Plato

class PoblarBaseDatosCallback(val context: Context):  RoomDatabase.Callback(){

    //se ejecuta despues que se hayan creado las tablas.
    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)

        Log.i("db", "onCreate()")

        val Categoriauno= Categoria(categoria = "Criolla",fotoCategoria = "aji")
        val Categoriados = Categoria(categoria = "Polleria",fotoCategoria = "pollos")
        val Categoriatres = Categoria(categoria = "Oriental",fotoCategoria = "chaufa")
        val Categoriacuatro = Categoria(categoria = "Pizza",fotoCategoria = "pizza")
        val Categoriacinco = Categoria(categoria = "caffe",fotoCategoria = "caffe")
        val Categoriaseis = Categoria(categoria = "Jugos",fotoCategoria = "jugo")
        //poner inserts




        Thread {
            val idcriolla=DemoApplication.database!!.categoriaDao().insertarCategoria(Categoriauno)
            val idPolleria=DemoApplication.database!!.categoriaDao().insertarCategoria(Categoriados)
            val idOriental=DemoApplication.database!!.categoriaDao().insertarCategoria(Categoriatres)
            val idPizza=DemoApplication.database!!.categoriaDao().insertarCategoria(Categoriacuatro)
            val idCaffe=DemoApplication.database!!.categoriaDao().insertarCategoria(Categoriacinco)
            val idJugos=DemoApplication.database!!.categoriaDao().insertarCategoria(Categoriaseis)


            val listaPlatos = ArrayList<Plato>()

            listaPlatos.add(Plato(categoriaId = idcriolla,nombrePlato = "Lomo Saltado", imagen = "lomo",precioPlato =  15.50,calorias = "1200 kl",descuento = 10,descripcion = context.getString(R.string.lomo)))
            listaPlatos.add(Plato(categoriaId = idcriolla,nombrePlato = "Arroz con pollo", imagen = "arroz",precioPlato =  10.50,calorias = "1200 kl",descuento = 10,descripcion = context.getString(R.string.arrozpollo)))
            listaPlatos.add(Plato(categoriaId = idcriolla,nombrePlato = "Ceviche", imagen = "ceviche",precioPlato =  20.50,calorias = "1200 kl",descuento = 10,descripcion = context.getString(R.string.ceviche)))
            listaPlatos.add(Plato(categoriaId = idcriolla,nombrePlato = "Rocoto Relleno", imagen = "rocoto",precioPlato =  17.00,calorias = "1200 kl",descuento = 10,descripcion = context.getString(R.string.rocoto)))
            listaPlatos.add(Plato(categoriaId = idcriolla,nombrePlato = "Aji de Gallina", imagen = "aji",precioPlato =  10.00,calorias = "1200 kl",descuento = 10,descripcion = context.getString(R.string.aji)))
            listaPlatos.add(Plato(categoriaId = idcriolla,nombrePlato = "papa a la Huancaina", imagen = "huancaina",precioPlato =  10.50,calorias = "1200 kl",descuento = 10,descripcion = context.getString(R.string.papahuancaina)))
            listaPlatos.add(Plato(categoriaId = idOriental,nombrePlato = "Cuy", imagen = "cuy",precioPlato =  25.50,calorias = "1200 kl",descuento = 10,descripcion = context.getString(R.string.cuy)))
            listaPlatos.add(Plato(categoriaId = idPolleria,nombrePlato = "Arroz Chaufa", imagen = "chaufa",precioPlato =  12.00,calorias = "1200 kl",descuento = 10,descripcion = context.getString(R.string.chaufa)))
            listaPlatos.add(Plato(categoriaId = idPizza,nombrePlato = "Cau Cau", imagen = "caucau",precioPlato =  10.50,calorias = "1200 kl",descuento = 10,descripcion = context.getString(R.string.caucau)))
            listaPlatos.add(Plato(categoriaId = idCaffe,nombrePlato = "Causa", imagen = "causa",precioPlato =  10.00,calorias = "1200 kl",descuento = 10,descripcion = context.getString(R.string.causa)))
            listaPlatos.add(Plato(categoriaId = idJugos,nombrePlato = "Escabeche", imagen = "escabeche",precioPlato =  13.50,calorias = "1200 kl",descuento = 10,descripcion = context.getString(R.string.escabeche)))

            DemoApplication.database!!.platoDao().insertarListaPlatos(listaPlatos)
        }.start()
    }

}