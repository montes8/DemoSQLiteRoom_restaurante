package com.example.eddymontesinos.demosqlite_romm.iu

import android.content.Intent

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eddymontesinos.demosqlite_romm.DemoApplication
import com.example.eddymontesinos.demosqlite_romm.R
import com.example.eddymontesinos.demosqlite_romm.adapter.CategoriaAdapter
import kotlinx.android.synthetic.main.activity_categoria.*

class CategoriaActivity : AppCompatActivity() {

    var categoriaAdapter: CategoriaAdapter? = null
    var handler : Handler = Handler()
    companion object {
        const val CATEGORIA_PARAM = "supermercado"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categoria)
        setSupportActionBar(CategoriaToolbar)
            title = "  CATEGORIAS"
            categoriaAdapter = CategoriaAdapter(this)
            categoriaAdapter?.onCategoriaClick={
                val intent = Intent(this,HomeActivity::class.java)
                intent.putExtra(CATEGORIA_PARAM, it)
                startActivity(intent)
            }
            my_recyclerviewCategoria.layoutManager = LinearLayoutManager(this)
            my_recyclerviewCategoria.layoutManager= GridLayoutManager(this,2)
            my_recyclerviewCategoria.adapter = categoriaAdapter

            Thread{
                val lista = DemoApplication.database!!.categoriaDao().litarSuperCategoria()
                handler.post {
                    categoriaAdapter!!.addList(lista)
                }
            }.start()

        }
    override fun onBackPressed() {

        moveTaskToBack(true)
    }
}
