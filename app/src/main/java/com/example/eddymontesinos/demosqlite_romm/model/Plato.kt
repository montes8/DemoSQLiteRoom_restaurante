package com.example.eddymontesinos.demosqlite_romm.model

class Plato {


    var idPlato : Long? = null
    var nombrePlato : String = ""
    var precioPlato : Double? = null

    constructor(idPlato: Long?, nombrePlato: String, precioPlato: Double?) {
        this.idPlato = idPlato
        this.nombrePlato = nombrePlato
        this.precioPlato = precioPlato
    }
}