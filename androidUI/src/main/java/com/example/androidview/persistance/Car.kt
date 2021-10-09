package com.example.androidview.persistance

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Car(
    @PrimaryKey val id : String,
    val model : String,
    val make : String
)