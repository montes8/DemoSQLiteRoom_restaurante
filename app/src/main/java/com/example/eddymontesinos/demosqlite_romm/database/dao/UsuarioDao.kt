package com.example.eddymontesinos.demosqlite_romm.database.dao

import android.arch.persistence.room.*
import com.example.eddymontesinos.demosqlite_romm.model.Usuario

@Dao
interface UsuarioDao {

    @Query("select * from Usuario")
    fun listarUsuario(): List<Usuario>

    @Query("select * from Usuario where nombreUsuario = :name and contrasenia = :pass")
    fun userLogin(name:String,pass:String):Usuario

    @Query("select * from Usuario where idUsu = :id")
    fun verDetalleUsuarioLogeado(id : String ): Usuario


    @Insert
    fun insert(usuarios: Usuario): Long

    @Delete
    fun deleteUser(usuarios: Usuario):Int

    @Update
    fun updateUser(usuarios: Usuario)
}