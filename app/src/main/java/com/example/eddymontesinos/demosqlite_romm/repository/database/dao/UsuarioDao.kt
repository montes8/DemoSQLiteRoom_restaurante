package com.example.eddymontesinos.demosqlite_romm.repository.database.dao

import androidx.room.*
import com.example.eddymontesinos.demosqlite_romm.model.Usuario

@Dao
interface UsuarioDao {

    @Query("select * from Usuario")
    fun listarUsuario(): List<Usuario>

    @Query("select * from Usuario where nombreUsuario = :name and contrasenia = :pass")
    fun userLogin(name:String,pass:String):Usuario

    @Query("select * from Usuario where idUsu = :id")
    fun verDetalleUsuarioLogeado(id : Long ): Usuario


    @Insert
    fun insert(usuarios: Usuario): Long

    @Delete
    fun deleteUser(usuarios: Usuario):Int

    @Update
    fun updateUser(usuarios: Usuario)
}