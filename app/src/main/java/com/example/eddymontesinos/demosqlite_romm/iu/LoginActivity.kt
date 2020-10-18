package com.example.eddymontesinos.demosqlite_romm.iu

import android.content.Intent
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.StyleSpan
import android.view.View
import com.example.eddymontesinos.demosqlite_romm.DemoApplication
import com.example.eddymontesinos.demosqlite_romm.R
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.*

class LoginActivity : AppCompatActivity() {

    var handler : Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        configurarTextoRegistrate()

        logearse()
    }

    fun configurarTextoRegistrate(){
        val string = getString(R.string.registrate)
        val spannableStringBuilder = SpannableStringBuilder(string)
        val boldSpan = StyleSpan(Typeface.BOLD)

        val clickableSpan = object: ClickableSpan() {

            override fun onClick(widget: View?) {
                val intent = Intent(this@LoginActivity, RegistrarActivity::class.java)
                startActivity(intent)
            }
        }
        spannableStringBuilder.setSpan(boldSpan, 13, string.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableStringBuilder.setSpan(clickableSpan, 13, string.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        tvRegistrate.text=spannableStringBuilder
        tvRegistrate.movementMethod = LinkMovementMethod.getInstance()

    }


    fun logearse(){
        button_login.setOnClickListener {

            Thread{
                val usuario= DemoApplication.database?.usuarioDao()?.userLogin(edit_nombre_login.text.toString(),edit_password_login.text.toString())

                if (usuario!=null){
                    handler.post {
                        defaultSharedPreferences.edit().putLong("idUsuarioLogeado",usuario.idUsu!!).apply()
                        toast("Bienvenida (o) ${usuario?.nombreUsuario}")
                        startActivity(intentFor<CategoriaActivity>().newTask().clearTask())
                    }
                }else {
                    handler.post {
                        toast("Usuario o Contraseña Incorrectos")
                    }
                }
            }.start()

        }

    }

}
