package com.example.eddymontesinos.demosqlite_romm.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.eddymontesinos.demosqlite_romm.DemoApplication
import com.example.eddymontesinos.demosqlite_romm.R
import com.example.eddymontesinos.demosqlite_romm.adapter.ListaPlatosAdarper
import com.example.eddymontesinos.demosqlite_romm.model.DetalleTemporal
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.clearTask
import org.jetbrains.anko.defaultSharedPreferences
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.newTask


class HomeActivity : AppCompatActivity() {

    var platosAdapter : ListaPlatosAdarper? = null

    var pedidos : ArrayList<DetalleTemporal> = ArrayList<DetalleTemporal>()
    //val idUsu = defaultSharedPreferences.getLong("idUsuarioLogeado",0)
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

            val idplato =it.idPlato
            val cantidad = 1
            val precio = it.precioPlato
            var subTotal = 0.0
            var contarplatos = 0
            pedidos.add(DetalleTemporal(idplato,cantidad,precio))
            pedidos.forEach {
                subTotal=subTotal+ it.precioDePlato!!
                contarplatos=contarplatos+cantidad
                Log.d("idDePlato","${it.idDePlato}")
                Log.d("cantidadPlato","${it.cantidadPlato}")
                Log.d("precioDePlato","${it.precioDePlato}")
            }

            val totalsub = subTotal
            val cantidades = contarplatos
            Log.d("totalplatos",""+cantidades)
            Log.d("totalpagar",""+totalsub)
                 Log.d("tot6allistas",""+pedidos.size)

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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_orden ->{
                val intent = Intent(this@HomeActivity,DetallePedidoActivity::class.java)
                startActivity(intent)
            }
            R.id.salir ->{
                startActivity(intentFor<LoginActivity>().newTask().clearTask())
            }

        }
        return super.onOptionsItemSelected(item)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

}
