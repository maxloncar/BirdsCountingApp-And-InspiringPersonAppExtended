package com.example.birdscountingapp

import android.app.Application
import android.content.Context

class BirdCounterApp: Application() {

    companion object{
        lateinit var ApplicationContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        ApplicationContext = this

    }
}