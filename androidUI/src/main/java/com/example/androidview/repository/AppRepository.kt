package com.example.androidview.repository

import androidx.room.withTransaction
import com.example.androidview.persistance.Car
import com.example.androidview.persistance.CarDatabase
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val persistence: CarDatabase
) {
    private val db = persistence.carDao();

    suspend fun transactions() = flow<Resource<entities.Car>> {

        persistence.withTransaction {
            db.getCars()
            db.addCar(Car("1", "bmw", "mss"))
        }

    }

}