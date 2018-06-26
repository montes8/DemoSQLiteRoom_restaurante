package com.example.eddymontesinos.demosqlite_romm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_registrar.*

class RegistrarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        ajusteToolbar()
    }


    private fun ajusteToolbar() {
        setSupportActionBar(mToolbar)
        title = getString(R.string.toolbar_registrate)
        mToolbar.navigationIcon = getDrawable(R.drawable.ic_flecha_back)
        mToolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}
