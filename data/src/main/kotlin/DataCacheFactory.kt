package com.cachedata

import interfaces.DataInterface
import io.reactivex.Completable
import io.reactivex.Single
import entities.Car
import io.reactivex.annotations.NonNull
import javax.inject.Inject

class DataCacheFactory @Inject constructor(val cardata: CarData) : DataInterface {

    override fun getCar(): Single<Car> {
        return Single.just<Car>(this.cardata.get());
    }

    override fun setCar(@NonNull name: String): Completable {
        this.cardata.set(name)
        return if(name == this.cardata.get().name)
            Completable.complete();
        else
            Completable.error(Throwable("car name error!"))
    }
}