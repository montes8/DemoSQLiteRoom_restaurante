package com.example.eddymontesinos.demosqlite_romm.views


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.eddymontesinos.demosqlite_romm.DemoApplication
import com.example.eddymontesinos.demosqlite_romm.R
import com.example.eddymontesinos.demosqlite_romm.adapter.HistorialAdarper
import com.example.eddymontesinos.demosqlite_romm.model.DetallePedido
import kotlinx.android.synthetic.main.activity_detalle_plato.*
import kotlinx.android.synthetic.main.activity_historial.*

class HistorialActivity : AppCompatActivity() {
    var historialAdapter : HistorialAdarper? = null

    var handler : Handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial)

       ajustarToolbarHistorial()
       recyclerView()


    }


    fun ajustarToolbarHistorial(){

        setSupportActionBar(historialToolbar)
        title = "Historial"
        historialToolbar.navigationIcon = getDrawable(R.drawable.ic_atras)
        historialToolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    fun recyclerView(){

        historialAdapter = HistorialAdarper(this)

        historial_recyclerview.layoutManager = LinearLayoutManager(this)
        historial_recyclerview.adapter = historialAdapter



        Thread {
            val lista = DemoApplication.database!!.detallePedidoDao().litarDetallePedido()

            handler.post {
                historialAdapter!!.addList(lista)
            }
        }.start()
    }



}
