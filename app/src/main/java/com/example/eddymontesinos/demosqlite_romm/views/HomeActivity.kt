package com.example.eddymontesinos.demosqlite_romm.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.eddymontesinos.demosqlite_romm.DemoApplication
import com.example.eddymontesinos.demosqlite_romm.R
import com.example.eddymontesinos.demosqlite_romm.adapter.ListaPlatosAdarper
import com.example.eddymontesinos.demosqlite_romm.model.DetalleTemporal
import com.example.eddymontesinos.demosqlite_romm.model.Plato
import com.example.eddymontesinos.demosqlite_romm.repository.temporal.OrdenTemporal
import com.example.eddymontesinos.demosqlite_romm.utils.Converters
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.dialog_cantidad.view.*
import org.jetbrains.anko.*


class HomeActivity : AppCompatActivity() {

    var platosAdapter : ListaPlatosAdarper? = null
    var handler :Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

      cargarRecycler()
    }

    override fun onResume() {
        super.onResume()
        invalidateOptionsMenu()
    }

    private fun ajusteToolbarHome() {
        setSupportActionBar(homeToolbar)
        title = "LISTA DE PLATOS"
    }

    private fun cargarRecycler(){

        platosAdapter = ListaPlatosAdarper(this)

        platosAdapter?.onDetalleClick ={
            val intent = Intent(this@HomeActivity,DetallePlatoActivity::class.java)
            intent.putExtra(DetallePlatoActivity.PLATO_PARAM, it)
            startActivity(intent)
        }

        platosAdapter?.onAgregarOrdenClick ={
            agregarOrActualizarItemOrden(it, 1)
            Toast.makeText(this@HomeActivity,"Orden Agregada",Toast.LENGTH_SHORT).show()

        }
        platosAdapter?.onAgregarCantidadClick ={plato ->

            val dialogBuilder = AlertDialog.Builder(this@HomeActivity)
            val dialogView = layoutInflater.inflate(R.layout.dialog_cantidad,null)

            dialogBuilder.setView(dialogView)
            dialogBuilder.setCancelable(true)

            dialogView.nombre_plato_dialog.text = plato.nombrePlato
            dialogView.precio_plato_dialog.text = "$/ "+plato.precioPlato.toString()

            val dialog = dialogBuilder.create()
            dialogView.btnagregar_orden_dialog.setOnClickListener{

                if(!dialogView.cantidad_plato_dialog.text.toString().isEmpty()){
                    toast("Orden Agregada")
                    val cantidadPlatoOrden = dialogView.cantidad_plato_dialog.text.toString().toInt()


                    agregarOrActualizarItemOrden(plato, cantidadPlatoOrden)

                    dialog.dismiss()
                }else{
                    toast("Ingrese Cantidad")
                }
            }


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

    fun agregarOrActualizarItemOrden(plato: Plato, cantidad: Int){
        val indicePlatoSiExiste = OrdenTemporal.buscarPlato(plato)

        if(indicePlatoSiExiste >= 0){

            val cantidadActual = OrdenTemporal.obtenerCantidadPlatoSegunIndice(indicePlatoSiExiste)

            val totalCantidad = cantidadActual+cantidad
            val pedidoActualizado = DetalleTemporal(plato, totalCantidad)

            OrdenTemporal.actualizarItemOrden(pedidoActualizado, indicePlatoSiExiste )
        }else{

            val nuevaOrden = DetalleTemporal(plato, cantidad)
            OrdenTemporal.agregarItemOrden(nuevaOrden)

            invalidateOptionsMenu()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        when(item.itemId){

            R.id.menu_orden ->{

                if(!OrdenTemporal.obtenerOrden().isEmpty()) {
                    val intents = Intent(this@HomeActivity, DetallePedidoActivity::class.java)
                    startActivity(intents)
                }else{
                    toast("No has ordenado aun")
                }
            }
            R.id.historial ->{
                Thread{
                    val listacomprobar = DemoApplication.database!!.pedidoDao().litarPedido()
                    if (listacomprobar.isEmpty()){
                        handler.post { toast("Historial vacio") }

                    }else{
                        handler.post { startActivity<HistorialMainActivity>() }
                    }
                }.start()
            }
            R.id.salir ->{
                defaultSharedPreferences.edit().putLong("idUsuarioLogeado",0).apply()
                startActivity(intentFor<LoginActivity>().newTask().clearTask())
            }
        }
        return super.onOptionsItemSelected(item)
        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.menu, menu)
            val menuItem =menu?.findItem(R.id.menu_orden)
            menuItem?.icon = Converters.convertLayoutToImage(this, OrdenTemporal.totalOrdenes(), R.drawable.ic_orden)
            return true
        }

    override fun onBackPressed() {

        moveTaskToBack(true)
    }
}




