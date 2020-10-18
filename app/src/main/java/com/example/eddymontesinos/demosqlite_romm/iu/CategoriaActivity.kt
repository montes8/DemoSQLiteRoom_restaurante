package com.example.eddymontesinos.demosqlite_romm.iu

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eddymontesinos.demosqlite_romm.R
import com.example.eddymontesinos.demosqlite_romm.adapter.CategoriaAdapter
import com.example.eddymontesinos.demosqlite_romm.model.Categoria
import com.example.eddymontesinos.demosqlite_romm.repository.network.DemoService
import kotlinx.android.synthetic.main.activity_categoria.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
               /* val intent = Intent(this,HomeActivity::class.java)
                intent.putExtra(CATEGORIA_PARAM, it)
                startActivity(intent)*/
            }
            my_recyclerviewCategoria.layoutManager = LinearLayoutManager(this)
            my_recyclerviewCategoria.layoutManager= GridLayoutManager(this,2)
            my_recyclerviewCategoria.adapter = categoriaAdapter
            val listaCallback = DemoService.create().getData()
            listaCallback.enqueue(object : Callback<ArrayList<Categoria>> {
                override fun onResponse(call: Call<ArrayList<Categoria>>?, response: Response<ArrayList<Categoria>>?) {
                    if (response?.code() == 200) {
                        val listaproducto = response.body()
                        if (listaproducto != null) {
                            categoriaAdapter?.addList(listaproducto)
                        }
                    }else{
                        Toast.makeText(this@CategoriaActivity, "Ocurrio un error al obtener la lista (${response?.code()})", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ArrayList<Categoria>>?, t: Throwable?) {

                    Toast.makeText(this@CategoriaActivity, "Ocurrio un error al obtener la lista", Toast.LENGTH_SHORT).show()
                }
            })

         /*   Thread{
                val lista = DemoApplication.database!!.categoriaDao().litarSuperCategoria()
                handler.post {
                    categoriaAdapter!!.addList(lista)
                }
            }.start()*/

        }
    override fun onBackPressed() {

        moveTaskToBack(true)
    }
}
