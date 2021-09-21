package interfaces

import io.reactivex.Completable
import io.reactivex.Single

interface DataInterface {
    fun getCar():Single<String>
    fun setCar(name: String):Completable
}