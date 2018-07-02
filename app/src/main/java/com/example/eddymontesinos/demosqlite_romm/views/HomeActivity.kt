package com.example.eddymontesinos.demosqlite_romm.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.example.eddymontesinos.demosqlite_romm.DemoApplication
import com.example.eddymontesinos.demosqlite_romm.R
import com.example.eddymontesinos.demosqlite_romm.adapter.ListaPlatosAdarper
import com.example.eddymontesinos.demosqlite_romm.model.DetalleTemporal
import com.example.eddymontesinos.demosqlite_romm.repository.temporal.OrdenTemporal
import kotlinx.android.synthetic.main.activity_detalle_plato.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.dialog_cantidad.view.*
import org.jetbrains.anko.clearTask
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.newTask


class HomeActivity : AppCompatActivity() {

    var platosAdapter : ListaPlatosAdarper? = null

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

        platosAdapter?.onAgregarOrdenClick ={

            val nuevaOrden = DetalleTemporal(it)

            OrdenTemporal.agregarItemOrden(nuevaOrden)

            /*
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
                 Log.d("tot6allistas",""+pedidos.size)*/

        }
        platosAdapter?.onAgregarCantidadClick ={

            val dialog = AlertDialog.Builder(this@HomeActivity)
            val dialogView = layoutInflater.inflate(R.layout.dialog_cantidad,null)

            //view.nombre_plato_dialog.text = it.nombrePlato
            //val nuevaOrden = DetalleTemporal(it,cantidad.text.toString().toInt())
            dialogView.nombre_plato_dialog.text = it.nombrePlato
            dialogView.precio_plato_dialog.text = it.precioPlato.toString()
            dialog.setView(dialogView)
            dialog.setCancelable(true)
            dialog.show()


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
