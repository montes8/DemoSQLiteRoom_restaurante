package com.example.eddymontesinos.demosqlite_romm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_historial_main.*

class HistorialMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial_main)
    }





    fun ajustarToolbarHistorial(){

        setSupportActionBar(historialprincipalToolbar)
        title = "Historial"
        historialprincipalToolbar.navigationIcon = getDrawable(R.drawable.ic_atras)
        historialprincipalToolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}
