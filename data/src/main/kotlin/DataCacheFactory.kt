package com.cachedata

import interfaces.DataInterface
import io.reactivex.Completable
import io.reactivex.CompletableOnSubscribe
import io.reactivex.Single
import models.Car
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class DataCacheFactory @Inject constructor(val cardata: CarData) : DataInterface {

    override fun getCar(): Single<Car> {
        return Single.just<Car>(this.cardata.get());
    }

    override fun setCar(name: String): Completable {
        return Completable.complete().doOnComplete { this.cardata.set(name) };
    }
}