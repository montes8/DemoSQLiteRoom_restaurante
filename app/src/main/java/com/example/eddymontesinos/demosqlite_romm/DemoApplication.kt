package com.example.eddymontesinos.demosqlite_romm

import android.app.Application
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.util.Log
import com.example.eddymontesinos.demosqlite_romm.database.DemoDataBase
import com.example.eddymontesinos.demosqlite_romm.database.PoblarBaseDatosCallback
import com.example.eddymontesinos.demosqlite_romm.model.Plato

class DemoApplication : Application() {

    companion object {

        var database : DemoDataBase? = null
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(this,DemoDataBase::class.java,"demo_restaurant.db")
                .addCallback(PoblarBaseDatosCallback())
                .build()
    }
}