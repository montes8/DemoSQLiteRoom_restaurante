package com.example.eddymontesinos.demosqlite_romm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.eddymontesinos.demosqlite_romm.adapter.ListaPlatosAdarper
import com.example.eddymontesinos.demosqlite_romm.model.Plato
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    var platosAdapter : ListaPlatosAdarper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)








        val listaPlatos : ArrayList<Plato> = ArrayList()

        listaPlatos.add(Plato(1,"plaTO",12.00))
        listaPlatos.add(Plato(1,"plaTO",12.00))
        listaPlatos.add(Plato(1,"plaTO",12.00))
        listaPlatos.add(Plato(1,"plaTO",12.00))
        listaPlatos.add(Plato(1,"plaTO",12.00))
        listaPlatos.add(Plato(1,"plaTO",12.00))
        listaPlatos.add(Plato(1,"plaTO",12.00))

        my_recyclerview.layoutManager = LinearLayoutManager(this)
        platosAdapter = ListaPlatosAdarper(listaPlatos,this@HomeActivity)
        my_recyclerview.adapter = platosAdapter
    }
}
