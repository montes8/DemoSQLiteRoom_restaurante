package com.example.eddymontesinos.demosqlite_romm.repository.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.eddymontesinos.demosqlite_romm.model.Categoria

@Dao
interface CategoriaDao {
    @Query("select * from Categoria")
    fun litarSuperCategoria(): List<Categoria>

    @Insert
    fun insertarListaCategorias(categoria : ArrayList<Categoria>) : Array<Long>
    @Insert
    fun insertarCategoria(categoria :Categoria) : Long
}