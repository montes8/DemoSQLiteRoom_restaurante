package com.example.eddymontesinos.demosqlite_romm.views


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.eddymontesinos.demosqlite_romm.R
import com.example.eddymontesinos.demosqlite_romm.adapter.DetalleAdapter
import com.example.eddymontesinos.demosqlite_romm.repository.temporal.OrdenTemporal
import kotlinx.android.synthetic.main.activity_detalle_pedido.*
import org.jetbrains.anko.toast

class DetallePedidoActivity : AppCompatActivity() {

    var detallesAdarper : DetalleAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pedido)
        ajustarToolbardetalle()
        detallesAdarper = DetalleAdapter(this)
        val orden = OrdenTemporal.obtenerOrden()

        orden.forEach {
            Log.v("detalleorden", it.toString())
        }
        //pedidosdetalle.add(DetalleTemporal(1,1,10.00))

        detallesAdarper?.addList(orden)
        pedido_recyclerview.layoutManager = LinearLayoutManager(this)
        pedido_recyclerview.adapter = detallesAdarper


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

}
