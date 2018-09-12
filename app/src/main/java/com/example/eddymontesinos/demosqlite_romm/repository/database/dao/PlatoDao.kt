package com.example.eddymontesinos.demosqlite_romm.repository.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
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