package com.example.eddymontesinos.demosqlite_romm

import android.app.Application
import androidx.room.Room
import com.example.eddymontesinos.demosqlite_romm.repository.database.DemoDataBase
import com.example.eddymontesinos.demosqlite_romm.repository.database.PoblarBaseDatosCallback

class DemoApplication : Application() {

    companion object {

        var database : DemoDataBase? = null
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(this,DemoDataBase::class.java,"demo_restaurant.db")
                .addCallback(PoblarBaseDatosCallback(this))
                .build()
    }
}