package com.example.eddymontesinos.demosqlite_romm.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eddymontesinos.demosqlite_romm.R
import com.example.eddymontesinos.demosqlite_romm.model.Categoria
import com.example.eddymontesinos.demosqlite_romm.model.Plato
import com.example.eddymontesinos.demosqlite_romm.utils.DemoUtils
import kotlinx.android.synthetic.main.item_molde_platos.view.*

class CategoriaAdapter (val contexto: Context, var onCategoriaClick: ((Categoria) -> Unit)? = null) : RecyclerView.Adapter<CategoriaAdapter.CategoriaViewHolder>(){

    private var categorias : List<Categoria>? = null

    fun addList(categorias : List<Categoria>){
        this.categorias = categorias

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.molde_categoria,parent,false)
        return CategoriaViewHolder(view)
    }

    override fun getItemCount(): Int {
        val checkedUser = checkNotNull(categorias){return 0}
        return checkedUser.size
    }


    override fun onBindViewHolder(holder: CategoriaViewHolder, position: Int) {
        val categoria = categorias!![position]


        holder.imageCategoria.setImageDrawable(DemoUtils.getImage(contexto, categoria.fotoCategoria))
        holder.txNombreCategoria.text = categoria.categoria
        holder.itemView.setOnClickListener{
            onCategoriaClick?.invoke(categoria)
        }
       

    }

    class CategoriaViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        val imageCategoria = itemView.image_view_plato
        val txNombreCategoria = itemView.text_nombre_pletoitem


    }
}