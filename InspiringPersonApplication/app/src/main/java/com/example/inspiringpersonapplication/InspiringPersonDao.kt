package com.example.inspiringpersonapplication

import androidx.room.*

@Dao
interface InspiringPersonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)    //ako su dvije iste osobe, zamijeni staru novom
    fun insertInspiringPerson(inspiringPerson: InspiringPerson)

    @Delete
    fun deleteInspiringPerson(inspiringPerson: InspiringPerson)

    @Query("SELECT * FROM inspiringPersons")
    fun getInspiringPersons(): List<InspiringPerson>

    @Query("SELECT * FROM inspiringPersons WHERE id = :id")
    fun getInspiringPerson(id: Int): InspiringPerson
}