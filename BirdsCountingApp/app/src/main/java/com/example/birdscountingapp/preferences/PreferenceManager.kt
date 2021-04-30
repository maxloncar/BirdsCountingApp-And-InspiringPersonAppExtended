package com.example.birdscountingapp.preferences

import android.content.Context
import com.example.birdscountingapp.BirdCounterApp
import com.example.birdscountingapp.databinding.ActivityMainBinding
import com.example.birdscountingapp.utilities.getBirdColor

class PreferenceManager {

    companion object {
        const val PREFS_FILE = "preferenceFile"
        const val PREFS_KEY_COUNTER = "BirdCounter"
        const val PREFS_KEY_COLOR = "seenBirdColor"
    }

    fun saveBirdCounterAndColor(birdColor: String) {
        val sharedPreferences = BirdCounterApp.ApplicationContext.getSharedPreferences(
            PREFS_FILE, Context.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        editor.putString(PREFS_KEY_COLOR, birdColor)
        val birdCounter = sharedPreferences.getInt(PREFS_KEY_COUNTER, 0)
        editor.putInt(PREFS_KEY_COUNTER, birdCounter + 1)
        editor.apply()
    }

    fun retrieveBirdCounter(): Int {
        val sharedPreferences = BirdCounterApp.ApplicationContext.getSharedPreferences(
            PREFS_FILE, Context.MODE_PRIVATE
        )
        return sharedPreferences.getInt(PREFS_KEY_COUNTER, 0)
    }

    fun retrieveBirdColor(): String {
        val sharedPreferences = BirdCounterApp.ApplicationContext.getSharedPreferences(
                PREFS_FILE, Context.MODE_PRIVATE
        )
        return sharedPreferences.getString(PREFS_KEY_COLOR, "")!!
    }

    fun resetBirdCounterAndColor(){
        val sharedPreferences = BirdCounterApp.ApplicationContext.getSharedPreferences(
                PREFS_FILE, Context.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        editor.putString(PREFS_KEY_COLOR, "")
        editor.putInt(PREFS_KEY_COUNTER, 0)
        editor.apply()
    }

}