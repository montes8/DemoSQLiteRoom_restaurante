package com.example.eddymontesinos.demosqlite_romm.iu



import android.os.Bundle
import android.os.Handler

import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eddymontesinos.demosqlite_romm.DemoApplication
import com.example.eddymontesinos.demosqlite_romm.R
import com.example.eddymontesinos.demosqlite_romm.adapter.DetalleAdapter
import com.example.eddymontesinos.demosqlite_romm.model.DetallePedido
import com.example.eddymontesinos.demosqlite_romm.model.Pedido
import com.example.eddymontesinos.demosqlite_romm.repository.temporal.OrdenTemporal
import kotlinx.android.synthetic.main.activity_detalle_pedido.*
import org.jetbrains.anko.defaultSharedPreferences
import org.jetbrains.anko.toast
import java.util.*

class DetallePedidoActivity : AppCompatActivity() {

    var detallesAdarper : DetalleAdapter? = null
    var handler : Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pedido)


        ajustarToolbardetalle()
        reciclerViewDetalle()



    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_ordenar_pedido ->{
                        Thread {
                            val fecha = mostrarFechaIngreso()
                            val idUsu = defaultSharedPreferences.getLong("idUsuarioLogeado",0)
                            val pedido = Pedido()
                            pedido.userId =idUsu
                            pedido.fecha =fecha
                            pedido.montoTotal = text_subtotal_ordenes.text.toString().toDouble()
                            pedido.direccion = edit_direccion.text.toString()

                            val nuevoIdPedido = DemoApplication.database!!.pedidoDao().insertPedido(pedido)

                            val detalleOrden = OrdenTemporal.obtenerOrden()
                            detalleOrden.forEach {
                                val detallePedido = DetallePedido()
                                detallePedido.pedidoId = nuevoIdPedido
                                detallePedido.platoId =it.plato.idPlato
                                detallePedido.cantidad=it.cantidad
                                detallePedido.subTotal=it.cantidad * it.plato.precioPlato
                               val a= DemoApplication.database!!.detallePedidoDao().insertDetallePedido(detallePedido)

                                Log.d("agregado correctamente","$a")
                            }
                            handler.post {

                                toast("Su Orden fue Registrado")
                                finish()
                                OrdenTemporal.limpiarOrden()
                            }

                        }.start()
            }


        }
        return super.onOptionsItemSelected(item)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_orden, menu)
        return true
    }


    private fun ajustarToolbardetalle(){

        setSupportActionBar(pedidoToolbar)
        title = ""
        pedidoToolbar.navigationIcon = getDrawable(R.drawable.ic_atras)
        pedidoToolbar.setNavigationOnClickListener {
            onBackPressed()}
    }


    fun reciclerViewDetalle(){
        detallesAdarper = DetalleAdapter(this)

        refrescarListaDetalle()
        pedido_recyclerview.layoutManager = LinearLayoutManager(this)
        pedido_recyclerview.adapter = detallesAdarper


        detallesAdarper?.onEliminarOrdenClick ={
            OrdenTemporal.eliminarOrden(it)
            if (OrdenTemporal.obtenerOrden().isEmpty()){
                finish()
            }else{
            refrescarListaDetalle()}
        }

    }

    fun refrescarListaDetalle(){

        val orden = OrdenTemporal.obtenerOrden()
         /*
        val listaFiltrada = ArrayList<DetalleTemporal>()

        orden.forEach { ordenItem ->

            var existe = false
            var indiceItemExistente = -1

            listaFiltrada.forEachIndexed {indice, ordenItemFiltro ->
                if(ordenItem.plato.idPlato == ordenItemFiltro.plato.idPlato){
                    existe = true
                    indiceItemExistente = indice
                }
            }

            if(existe){
                val detalleExistente = listaFiltrada[indiceItemExistente]
                detalleExistente.cantidad = detalleExistente.cantidad + ordenItem.cantidad

                listaFiltrada[indiceItemExistente] = detalleExistente
            } else {
                listaFiltrada.add(ordenItem)
            }
        }*/
        detallesAdarper?.addList(orden)
        ontenidototal()

    }

    fun ontenidototal(){

        val ordentotal = OrdenTemporal.obtenerOrden()
        var total=0.00
        ordentotal.forEach {
            total = total + it.plato.precioPlato * it.cantidad
        }
        text_subtotal_ordenes.text = total.toString()

    }

    fun mostrarFechaIngreso():String{

        val c= Calendar.getInstance()
        val dia=c.get(Calendar.DAY_OF_MONTH)
        val mes=c.get(Calendar.MONTH)
        val mess=mes+1
        val anio=c.get(Calendar.YEAR)
        val fecha = "$dia / $mess / $anio"

        return fecha
    }

}
