package com.example.inspiringpersonapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.inspiringpersonapplication.databinding.ActivityAddNewInspiringPersonBinding
import com.example.inspiringpersonapplication.databinding.ActivityMainBinding

class AddNewInspiringPersonActivity : AppCompatActivity() {

    private lateinit var addNewInspiringPersonBinding: ActivityAddNewInspiringPersonBinding
    private val inspiringPersonDao = InspiringPersonDatabase.getInstance().inspiringPersonDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_inspiring_person)
        addNewInspiringPersonBinding = ActivityAddNewInspiringPersonBinding.inflate(layoutInflater)
        addNewInspiringPersonBinding.bAdd.setOnClickListener { addInspiringPerson() }
        setContentView(addNewInspiringPersonBinding.root)
    }

    private fun addInspiringPerson(){
        val inspiringPersonName = addNewInspiringPersonBinding.tietNameInput.text.toString()
        val inspiringPersonDateOfBirthAndDeath = addNewInspiringPersonBinding.tietDateOfBirthAndDeathInput.text.toString()
        val inspiringPersonDescription = addNewInspiringPersonBinding.tietDescriptionInput.text.toString()
        val inspiringPersonQuote = addNewInspiringPersonBinding.tietQuoteInput.text.toString()
        val inspiringPerson = InspiringPerson(0, inspiringPersonName, inspiringPersonName, inspiringPersonDateOfBirthAndDeath, inspiringPersonDescription)

        if (inspiringPersonName.isNotEmpty() && inspiringPersonDateOfBirthAndDeath.isNotEmpty() && inspiringPersonDescription.isNotEmpty() && inspiringPersonQuote.isNotEmpty()){
            inspiringPersonDao.insertInspiringPerson(inspiringPerson)
            PeopleRepository.insertInspiringPersonQuote(inspiringPersonName, inspiringPersonQuote)
            finish()
        }
        else{
            Toast.makeText(this, "These inputs are required", Toast.LENGTH_LONG).show()
        }
    }
}