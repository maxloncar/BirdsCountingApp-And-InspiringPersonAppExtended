package com.example.inspiringpersonapplication
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "inspiringPersons")
data class InspiringPerson (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "imageLink") val image: String,
    @ColumnInfo(name = "birthAndDeathDate") val dateOfBirthAndDeath: String,
    @ColumnInfo(name = "description") val description: String
    ) : Serializable