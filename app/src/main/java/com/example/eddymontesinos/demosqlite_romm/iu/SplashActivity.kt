package com.example.eddymontesinos.demosqlite_romm.iu

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.eddymontesinos.demosqlite_romm.R
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.defaultSharedPreferences
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val anima : Animation
        val anima2 : Animation

        anima = AnimationUtils.loadAnimation(this, R.anim.animacion)
        anima2 = AnimationUtils.loadAnimation(this, R.anim.animacion_botton)
        once.animation=anima
        doce.animation=anima2


        llamarSplash()
    }


    fun llamarSplash (){
        val background = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep((3*1000).toLong())
                    val idUsuarioLogeado = defaultSharedPreferences.getLong("idUsuarioLogeado",0)

                    if (idUsuarioLogeado > 0){

                        startActivity<CategoriaActivity>()
                    }else{
                        val i = Intent(baseContext, LoginActivity::class.java)
                        startActivity(i)
                    }

                    finish()
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
        }
        background.start()
    }
}
