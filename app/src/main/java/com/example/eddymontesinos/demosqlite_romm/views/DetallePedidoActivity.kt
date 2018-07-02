package com.example.eddymontesinos.demosqlite_romm.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.eddymontesinos.demosqlite_romm.R
import kotlinx.android.synthetic.main.activity_detalle_pedido.*
import kotlinx.android.synthetic.main.activity_detalle_plato.*

class DetallePedidoActivity : AppCompatActivity() {

    //val idPlato = defaultSharedPreferences.getLong("idpaltoid",0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pedido)

        setSupportActionBar(pedidoToolbar)
        title = ""
        pedidoToolbar.navigationIcon = getDrawable(R.drawable.ic_flecha_back)
        pedidoToolbar.setNavigationOnClickListener {
            onBackPressed()}


    }

}
