package com.example.eddymontesinos.demosqlite_romm.repository.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.eddymontesinos.demosqlite_romm.model.Plato

@Dao
interface PlatoDao {

    @Query("select * from Plato")
    fun litarPlatos(): List<Plato>

    @Query("select * from Plato where categoriaId = :Id ")
    fun verPlatoSegunCategoria (Id:Long) : List<Plato>

    @Insert
    fun insertarListaPlatos(plato : ArrayList<Plato>) : Array<Long>
}