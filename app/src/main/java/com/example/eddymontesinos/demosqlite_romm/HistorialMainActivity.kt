package com.example.eddymontesinos.demosqlite_romm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import com.example.eddymontesinos.demosqlite_romm.adapter.HistorialAdapter
import com.example.eddymontesinos.demosqlite_romm.views.HistorialPedidoActivity
import kotlinx.android.synthetic.main.activity_historial_main.*
import org.jetbrains.anko.defaultSharedPreferences
import org.jetbrains.anko.startActivity

class HistorialMainActivity : AppCompatActivity() {

    var hAdapter : HistorialAdapter? = null
    var handler : Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial_main)

        ajustarToolbarHistorial()

        recyclerViewHistorial()


    }





    fun ajustarToolbarHistorial(){

        setSupportActionBar(historialprincipalToolbar)
        title = "Historial"
        historialprincipalToolbar.navigationIcon = getDrawable(R.drawable.ic_atras)
        historialprincipalToolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }


    private fun recyclerViewHistorial(){
        hAdapter = HistorialAdapter()


        hAdapter?.onDetallePedidoClick ={

            defaultSharedPreferences.edit().putLong("idpedidohistorial",it.idPedido!!.toLong()).apply()
            startActivity<HistorialPedidoActivity>()
        }

        principalh_recyclerview.layoutManager = LinearLayoutManager(this)
        principalh_recyclerview.adapter = hAdapter

        Thread {
            val lista = DemoApplication.database!!.pedidoDao().litarPedido()

            handler.post {
                hAdapter!!.addList(lista)
            }
        }.start()

    }
}
