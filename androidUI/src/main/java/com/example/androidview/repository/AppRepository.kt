package com.example.androidview.repository

import com.example.androidview.persistance.CarDatabase
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val persistence: CarDatabase
) {
    val db = persistence.carDao()


}