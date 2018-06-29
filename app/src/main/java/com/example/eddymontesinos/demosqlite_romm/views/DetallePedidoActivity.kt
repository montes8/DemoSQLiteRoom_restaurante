package com.example.eddymontesinos.demosqlite_romm.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.eddymontesinos.demosqlite_romm.R
import com.example.eddymontesinos.demosqlite_romm.model.DetalleTemporal
import kotlinx.android.synthetic.main.activity_detalle_pedido.*

class DetallePedidoActivity : AppCompatActivity() {

    var detalleTemporal : DetalleTemporal? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pedido)
        detalleTemporal = DetalleTemporal()


        textiddetalletemporal.text = detalleTemporal!!.idDePlato.toString()
        textprecioplstot.text = detalleTemporal!!.precioDePlato.toString()
        textcantidadt.text = detalleTemporal!!.cantidadPlato.toString()




    }

}
