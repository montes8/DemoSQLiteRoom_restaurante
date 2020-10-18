package com.example.eddymontesinos.demosqlite_romm.iu

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.os.Handler
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.StyleSpan
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.eddymontesinos.demosqlite_romm.DemoApplication
import com.example.eddymontesinos.demosqlite_romm.R
import com.example.eddymontesinos.demosqlite_romm.repository.network.DemoService
import com.example.eddymontesinos.demosqlite_romm.repository.network.request.LoginRequest
import com.example.eddymontesinos.demosqlite_romm.repository.network.response.User
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
            override fun onClick(widget: View) {
                val intent = Intent(this@LoginActivity, RegistrarActivity::class.java)
                startActivity(intent)
            }
        }
        spannableStringBuilder.setSpan(boldSpan, 13, string.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableStringBuilder.setSpan(clickableSpan, 13, string.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        tvRegistrate.text=spannableStringBuilder
        tvRegistrate.movementMethod = LinkMovementMethod.getInstance()

    }

    fun loginService(user : String, pass : String){

        val listaCallback = DemoService.create().login(LoginRequest(user,pass))
        listaCallback.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>?, response: Response<User>?) {
                if (response?.code() == 200) {
                    val responseUser = response.body()
                    responseUser?.success?.apply {
                        if (this){
                            startActivity(intentFor<CategoriaActivity>().newTask().clearTask())
                        }else{
                            Toast.makeText(this@LoginActivity, "Usuario incorrecto", Toast.LENGTH_SHORT).show()
                        }
                    }


                }else{
                    Toast.makeText(this@LoginActivity, "Ocurrio un error al obtener la lista (${response?.code()})", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<User>?, t: Throwable?) {

                Toast.makeText(this@LoginActivity, "Ocurrio un error al obtener la lista", Toast.LENGTH_SHORT).show()
            }
        })
    }


    fun logearse(){
        button_login.setOnClickListener {
           loginService(edit_nombre_login.text.toString(),edit_password_login.text.toString())
            //loginService(edit_nombre_login.text.toString(),edit_password_login.text.toString())
         /*   Thread{
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
            }.start()*/

        }

    }

}
