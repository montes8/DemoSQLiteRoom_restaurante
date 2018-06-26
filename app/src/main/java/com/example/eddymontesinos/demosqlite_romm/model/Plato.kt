package com.example.eddymontesinos.demosqlite_romm.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Plato(@PrimaryKey(autoGenerate = true) var idPlato : Long? = null, val nombrePlato: String, val imagen: String, val precioPlato: Double)