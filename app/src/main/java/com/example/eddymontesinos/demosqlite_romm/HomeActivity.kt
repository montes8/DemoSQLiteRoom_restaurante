package com.example.eddymontesinos.demosqlite_romm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.eddymontesinos.demosqlite_romm.adapter.ListaPlatosAdarper
import com.example.eddymontesinos.demosqlite_romm.model.Plato
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_registrar.*

class HomeActivity : AppCompatActivity() {

    var platosAdapter : ListaPlatosAdarper? = null

    var handler :Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        platosAdapter = ListaPlatosAdarper()
        my_recyclerview.layoutManager = LinearLayoutManager(this)
        my_recyclerview.adapter = platosAdapter

      ajusteToolbarHome()

      Thread {
          val lista = DemoApplication.database!!.platoDao().litarPlatos()
          handler.post {
              platosAdapter!!.addList(lista)
          }
      }.start()


    }

    private fun ajusteToolbarHome() {
        setSupportActionBar(homeToolbar)
        title = "LISTA DE PLATOS DE HOY"
    }

    private fun isertarPlatos(){

        Thread{



        }.start()
    }


}
