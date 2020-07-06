package com.example.eddymontesinos.demosqlite_romm.utils

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat


object DemoUtils {

    fun getImage(c: Context, imageName: String): Drawable? {
        val id = c.resources.getIdentifier(imageName, "drawable", c.packageName)
        if(id != 0){
            return ContextCompat.getDrawable(c, id)
        }
        return null
    }
}