package com.example.inspiringpersonapplication

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 1, entities = [InspiringPerson::class])
abstract class InspiringPersonDatabase: RoomDatabase() {

    abstract fun inspiringPersonDao(): InspiringPersonDao

    companion object {
        private const val NAME = "inspiringPerson_database"
        private var INSTANCE: InspiringPersonDatabase? = null

        fun getInstance(): InspiringPersonDatabase{
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    InspiringPersonApp.ApplicationContext,
                    InspiringPersonDatabase::class.java,
                    NAME)
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE as InspiringPersonDatabase
        }
    }
}