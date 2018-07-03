package com.example.eddymontesinos.demosqlite_romm.views


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.eddymontesinos.demosqlite_romm.R
import com.example.eddymontesinos.demosqlite_romm.adapter.DetalleAdapter
import com.example.eddymontesinos.demosqlite_romm.model.DetalleTemporal
import com.example.eddymontesinos.demosqlite_romm.model.Plato
import com.example.eddymontesinos.demosqlite_romm.repository.temporal.OrdenTemporal
import kotlinx.android.synthetic.main.activity_detalle_pedido.*
import org.jetbrains.anko.defaultSharedPreferences
import org.jetbrains.anko.support.v4.defaultSharedPreferences
import org.jetbrains.anko.toast

class DetallePedidoActivity : AppCompatActivity() {

    var detallesAdarper : DetalleAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pedido)


        ajustarToolbardetalle()
        reciclerViewDetalle()



    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_ordenar_pedido ->{

                toast("pedido ingresado")
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
            refrescarListaDetalle()
        }

    }

    fun refrescarListaDetalle(){

        val orden = OrdenTemporal.obtenerOrden()
        detallesAdarper?.addList(orden)
        ontenidoSubtotal()

    }
    fun ontenidoSubtotal(){

        val ordentotal = OrdenTemporal.obtenerOrden()
        var subtotal=0.00
        ordentotal.forEach {
            subtotal = subtotal + it.plato.precioPlato * it.cantidad
        }
        text_subtotal_ordenes.text = subtotal.toString()

    }

}
