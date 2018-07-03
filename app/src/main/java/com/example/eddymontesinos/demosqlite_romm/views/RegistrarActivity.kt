package com.example.eddymontesinos.demosqlite_romm.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.example.eddymontesinos.demosqlite_romm.DemoApplication
import com.example.eddymontesinos.demosqlite_romm.R
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

                    if (edit_text_nombre.text.toString().isEmpty()) {

                        handler.post { toast("ingrese nombre") }

                    }else if(edit_text_user.text.toString().isEmpty()){
                        handler.post { toast("Ingrese nombre de usuario") }

                    }else if(edit_password.text.toString().isEmpty()){
                        handler.post { toast("Ingrese contraseña") }

                    }else if(edit_pais.text.toString().isEmpty()){
                        handler.post { toast("Ingrese pais") }
                    }else {
                        val usuario = Usuario()
                        usuario.nombre = edit_text_nombre.text.toString()
                        usuario.nombreUsuario = edit_text_user.text.toString()
                        usuario.contrasenia = edit_password.text.toString()
                        usuario.pais = edit_pais.text.toString()

                        val nuevoId = DemoApplication.database!!.usuarioDao().insert(usuario)
                        defaultSharedPreferences.edit().putLong("idUsuarioLogeado",nuevoId).apply()
                        if (nuevoId > 0) {
                            Log.i("idregistrado", "$nuevoId")
                            handler.post {
                                toast("Usuario Registrado")
                                edit_text_nombre.setText("")
                                edit_text_user.setText("")
                                edit_password.setText("")
                                edit_pais.setText("")

                                startActivity(intentFor<HomeActivity>().newTask().clearTask())
                            }
                        } else {
                            handler.post { toast("errorrrr") }
                        }
                    }
                }.start()

        }
    }

}
