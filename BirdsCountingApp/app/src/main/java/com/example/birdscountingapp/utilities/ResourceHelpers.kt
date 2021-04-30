package com.example.birdscountingapp.utilities

import android.graphics.Color
import android.graphics.Color.TRANSPARENT
import com.example.birdscountingapp.R

fun getBirdColor(birdColor: String): Int{
    return when(birdColor){
        "red" -> R.color.red
        "blue" -> R.color.blue
        "green" -> R.color.green
        "yellow" -> R.color.yellow
        else -> TRANSPARENT
    }
}