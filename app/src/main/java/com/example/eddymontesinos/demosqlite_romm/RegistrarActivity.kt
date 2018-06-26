package com.example.eddymontesinos.demosqlite_romm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.example.eddymontesinos.demosqlite_romm.model.Usuario
import kotlinx.android.synthetic.main.activity_registrar.*
import org.jetbrains.anko.*

class RegistrarActivity : AppCompatActivity() {

    var handler : Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        ajusteToolbar()

        registrarUsuario()
    }


    private fun ajusteToolbar() {
        setSupportActionBar(mToolbar)
        title = getString(R.string.toolbar_registrate)
        mToolbar.navigationIcon = getDrawable(R.drawable.ic_flecha_back)
        mToolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun registrarUsuario() {
        button_click_register.setOnClickListener {


            Thread {
                val usuario = Usuario()
                usuario.nombre = edit_text_nombre.text.toString()
                usuario.nombreUsuario = edit_text_user.text.toString()
                usuario.contrasenia = edit_password.text.toString()
                usuario.pais = edit_pais.text.toString()

                val nuevoId = DemoApplication.database!!.usuarioDao().insert(usuario)
                //val a:Int = resultado.toInt()
                if (nuevoId > 0) {
                    Log.i("idregistrado", "$nuevoId")
                    handler.post {
                        toast("Usuario Registrado")
                        edit_text_nombre.setText("")
                        edit_text_user.setText("")
                        edit_password.setText("")
                        edit_pais.setText("")

                        defaultSharedPreferences.edit().putString("idUsuarioLogeado", nuevoId.toString()).apply()

                        startActivity(intentFor<HomeActivity>().newTask().clearTask())
                    }
                } else {
                    handler.post { toast("errorrrr") }
                }
            }.start()


        }
    }
}
