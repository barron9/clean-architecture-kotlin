package com.example.androidview.persistance

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CarDao {
    // When returning LiveData, you should not use a suspend function because they are incompatible (and not needed).
    @Query("SELECT * FROM car")
    fun getCars() : LiveData<List<Car>>

    @Insert
    fun addCar(car:Car)
}