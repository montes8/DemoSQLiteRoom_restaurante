package com.example.eddymontesinos.demosqlite_romm.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.eddymontesinos.demosqlite_romm.R
import com.example.eddymontesinos.demosqlite_romm.model.Plato
import com.example.eddymontesinos.demosqlite_romm.utils.DemoUtils
import kotlinx.android.synthetic.main.activity_detalle_plato.*
import kotlinx.android.synthetic.main.activity_registrar.*
import kotlinx.android.synthetic.main.item_molde_platos.*

class DetallePlatoActivity : AppCompatActivity() {

    companion object {
        const val PLATO_PARAM = "plato"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_plato)
        val detallesPlatos = intent.getParcelableExtra<Plato>(PLATO_PARAM)

        setSupportActionBar(detalleToolbar)
        title = detallesPlatos.nombrePlato
        detalleToolbar.navigationIcon = getDrawable(R.drawable.ic_atras)
        detalleToolbar.setNavigationOnClickListener {
            onBackPressed()
        }



        image_plato.setImageDrawable(DemoUtils.getImage(this,detallesPlatos.imagen))
        text_precio_detalle.setText("$ "+detallesPlatos.precioPlato.toString() )
        text_calorias.setText(detallesPlatos.calorias)
        text_descuento.setText(detallesPlatos.descuento.toString()+"%")
        text_descripcion.setText(detallesPlatos.descripcion)




    }

}
