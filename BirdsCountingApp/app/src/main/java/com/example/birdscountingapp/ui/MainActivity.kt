package com.example.birdscountingapp.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.birdscountingapp.databinding.ActivityMainBinding
import com.example.birdscountingapp.preferences.PreferenceManager
import com.example.birdscountingapp.utilities.getBirdColor
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            it.bRedBirdsSeen.setOnClickListener {
                seeRedBird()
            }
            it.bBlueBirdsSeen.setOnClickListener {
                seeBlueBird()
            }
            it.bGreenBirdsSeen.setOnClickListener {
                seeGreenBird()
            }
            it.bYellowBirdsSeen.setOnClickListener {
                seeYellowBird()
            }
            it.bReset.setOnClickListener {
                resetCounterAndColor()
            }
        }
        initializeBirdCounterAndColor()
        setContentView(binding.root)

    }

    private fun initializeBirdCounterAndColor() {
        val preferenceManager = PreferenceManager()
        val birdCounter = preferenceManager.retrieveBirdCounter()
        val birdColor = preferenceManager.retrieveBirdColor()

        if (birdColor != null) {
            updateBirdCounterAndColor(birdCounter, birdColor)
        }
    }

    private fun updateBirdCounterAndColor(birdCounter: Int, birdColor: String) {
        binding.tvCounter.text = "$birdCounter"
        binding.tvCounter.setBackgroundResource(getBirdColor(birdColor))
    }

    private fun resetCounterAndColor() {
        val preferenceManager = PreferenceManager()
        preferenceManager.resetBirdCounterAndColor()
        updateBirdCounterAndColor(0, "")
    }

    private fun seeRedBird() {
        val preferenceManager = PreferenceManager()
        preferenceManager.saveBirdCounterAndColor("red")
        val birdCounter = preferenceManager.retrieveBirdCounter()
        val birdColor = preferenceManager.retrieveBirdColor()
        updateBirdCounterAndColor(birdCounter, birdColor)
    }

    private fun seeBlueBird() {
        val preferenceManager = PreferenceManager()
        preferenceManager.saveBirdCounterAndColor("blue")
        val birdCounter = preferenceManager.retrieveBirdCounter()
        val birdColor = preferenceManager.retrieveBirdColor()
        updateBirdCounterAndColor(birdCounter, birdColor)
    }

    private fun seeGreenBird() {
        val preferenceManager = PreferenceManager()
        preferenceManager.saveBirdCounterAndColor("green")
        val birdCounter = preferenceManager.retrieveBirdCounter()
        val birdColor = preferenceManager.retrieveBirdColor()
        updateBirdCounterAndColor(birdCounter, birdColor)
    }

    private fun seeYellowBird() {
        val preferenceManager = PreferenceManager()
        preferenceManager.saveBirdCounterAndColor("yellow")
        val birdCounter = preferenceManager.retrieveBirdCounter()
        val birdColor = preferenceManager.retrieveBirdColor()
        updateBirdCounterAndColor(birdCounter, birdColor)
    }
}