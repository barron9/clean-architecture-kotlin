package com.example.androidview.persistance

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Car::class], version = 1)
abstract class CarDatabase : RoomDatabase() {
    abstract fun carDao(): CarDao
}