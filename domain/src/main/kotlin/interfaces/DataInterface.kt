package interfaces

import io.reactivex.Completable
import io.reactivex.Single
import entities.Car

interface DataInterface {
    fun getCar():Single<Car>
    fun setCar(name: String):Completable
}