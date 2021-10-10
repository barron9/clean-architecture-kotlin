package com.example.androidview.persistance

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CarDao {
    // When returning LiveData, you should not use a suspend function because they are incompatible (and not needed).
    @Query("SELECT * FROM car")
    fun getCars(): Flow<List<Car>>

    @Insert
    fun addCar(car: Car)
}