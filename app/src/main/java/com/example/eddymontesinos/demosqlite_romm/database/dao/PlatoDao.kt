package com.example.eddymontesinos.demosqlite_romm.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.eddymontesinos.demosqlite_romm.model.Plato

@Dao
interface PlatoDao {

    @Query("select * from Plato")
    fun litarPlatos(): List<Plato>

    @Insert
    fun insertarListaPlatos(plato : ArrayList<Plato>) : Array<Long>
}