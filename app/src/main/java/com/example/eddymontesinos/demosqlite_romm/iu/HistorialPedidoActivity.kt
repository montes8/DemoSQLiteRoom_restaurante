package com.example.eddymontesinos.demosqlite_romm.iu

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eddymontesinos.demosqlite_romm.DemoApplication
import com.example.eddymontesinos.demosqlite_romm.R
import com.example.eddymontesinos.demosqlite_romm.adapter.HistorialPedidoAdarper
import kotlinx.android.synthetic.main.activity_historial_pedido.*
import org.jetbrains.anko.defaultSharedPreferences

class HistorialPedidoActivity : AppCompatActivity() {
    var historialAdapter : HistorialPedidoAdarper? = null

    var handler : Handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial_pedido)

       ajustarToolbarHistorial()
       recyclerView()


    }


    fun ajustarToolbarHistorial(){

        setSupportActionBar(historialToolbar)
        title = "Historial de pedido"
        historialToolbar.navigationIcon = getDrawable(R.drawable.ic_atras)
        historialToolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    fun recyclerView(){

        historialAdapter = HistorialPedidoAdarper(this)

        historial_recyclerview.layoutManager = LinearLayoutManager(this)
        historial_recyclerview.adapter = historialAdapter



        Thread {
            val idPedido = defaultSharedPreferences.getLong("idpedidohistorial",0)
            val lista = DemoApplication.database!!.detallePedidoDao().litarDetallePedidoId(idPedido)

            handler.post {
                historialAdapter!!.addList(lista)
            }
        }.start()
    }



}
