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

    fun transactions(q: String) = flow {

        val res = persistence.withTransaction {
            db.addCar(Car("1", "bmw", "mss"))
            db.getCars()
        }
        val r = Resource.Success(res)
        emit(r)

    }

}