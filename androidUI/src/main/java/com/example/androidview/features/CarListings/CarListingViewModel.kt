package com.example.androidview.features.CarListings

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.di.DaggerAppComp
import com.example.androidview.repository.AppRepository
import entities.CarMake
import entities.CarResponse
import interfaces.NetworkInterface
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class CarListingViewModel @Inject constructor(
    val repository: AppRepository
) : ViewModel() {

    suspend fun sync() = repository.transactions().asLiveData()

    companion object {
        var dagger = DaggerAppComp.create()
        val service: NetworkInterface = dagger.getNetwwork()
        var data: Observable<CarResponse?>? = service.GetMakeForManufacturer("a")
        var bs: BehaviorSubject<CarResponse?> = BehaviorSubject.create<CarResponse?>()
        var loader: BehaviorSubject<Boolean?> = BehaviorSubject.create<Boolean?>()
        var resultdata: MutableLiveData<List<CarMake>> = MutableLiveData<List<CarMake>>()

        @SuppressLint("CheckResult")
        fun call(q: String): BehaviorSubject<CarResponse?>? {
            Log.e("Pageviewmodel", Thread.currentThread().name)
            loader.onNext(true)
            service.GetMakeForManufacturer(q)
                .subscribe { s ->
                    bs.onNext(s!!)
                    loader.onNext(false)
                    resultdata.postValue(s.Results)
                    Log.e("Pageviewmodel", Thread.currentThread().name)
                }
            return bs
        }

        fun result(o: CarResponse?) {
            Log.e("Pageviewmodel inresult", Thread.currentThread().name)
            bs.onNext(o!!)
        }
    }


}


