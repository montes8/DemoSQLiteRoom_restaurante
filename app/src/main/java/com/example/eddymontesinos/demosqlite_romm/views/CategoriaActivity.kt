package com.example.eddymontesinos.demosqlite_romm.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.example.eddymontesinos.demosqlite_romm.DemoApplication
import com.example.eddymontesinos.demosqlite_romm.R
import com.example.eddymontesinos.demosqlite_romm.adapter.CategoriaAdapter
import com.example.eddymontesinos.demosqlite_romm.adapter.ListaPlatosAdarper
import kotlinx.android.synthetic.main.activity_categoria.*

class CategoriaActivity : AppCompatActivity() {

    var categoriaAdapter: CategoriaAdapter? = null
    var handler : Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categoria)
        setSupportActionBar(CategoriaToolbar)
        title = "  CATEGORIAS"
        categoriaAdapter = CategoriaAdapter(this)
        my_recyclerviewCategoria.layoutManager = LinearLayoutManager(this)
        my_recyclerviewCategoria.layoutManager=GridLayoutManager(this,2)
        my_recyclerviewCategoria.adapter = categoriaAdapter

        Thread{
            val lista = DemoApplication.database!!.categoriaDao().litarSuperCategoria()
            handler.post {
                categoriaAdapter!!.addList(lista)
            }
        }.start()
        }
}
