package com.example.eddymontesinos.demosqlite_romm.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.eddymontesinos.demosqlite_romm.DemoApplication
import com.example.eddymontesinos.demosqlite_romm.R
import com.example.eddymontesinos.demosqlite_romm.adapter.ListaPlatosAdarper
import com.example.eddymontesinos.demosqlite_romm.model.DetallePedido
import com.example.eddymontesinos.demosqlite_romm.model.Pedido
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.defaultSharedPreferences


class HomeActivity : AppCompatActivity() {

    var platosAdapter : ListaPlatosAdarper? = null
    val idUsu = defaultSharedPreferences.getLong("idUsuarioLogeado",0)
    var handler :Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

      cargarRecycler()


    }

    private fun ajusteToolbarHome() {
        setSupportActionBar(homeToolbar)
        title = "LISTA DE PLATOS DE HOY"
    }

    private fun cargarRecycler(){

        platosAdapter = ListaPlatosAdarper(this)

        platosAdapter?.onDetalleClick ={
            val intent = Intent(this@HomeActivity,DetallePlatoActivity::class.java)
            intent.putExtra(DetallePlatoActivity.PLATO_PARAM, it)
            startActivity(intent)
        }

        platosAdapter?.onAddClick ={

            val pedidos = ArrayList<DetallePedido>()
            val idplato =it.idPlato
            val cantidad = 1
            val subTotal = it.precioPlato

            pedidos.add(DetallePedido(null,null,idplato,cantidad,subTotal))

            Log.d("listaas detalles","$pedidos")
        }




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

}
