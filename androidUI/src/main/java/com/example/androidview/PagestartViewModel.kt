package com.example.androidview

import androidx.lifecycle.ViewModel
import com.di.DaggerAppComp

import entities.CarResponse
import interfaces.NetworkInterface
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject

class PagestartViewModel : ViewModel() {

    companion object {
        var dagger = DaggerAppComp.create()
        val service : NetworkInterface = dagger.getNetwwork()
        var data: Observable<CarResponse?>? = service.GetMakeForManufacturer("a")
        val bs:BehaviorSubject<CarResponse?> = BehaviorSubject.create<CarResponse?>()

        fun call(q:String) : Observable<CarResponse?>?{
            bs.onNext(service.GetMakeForManufacturer(q).observeOn(Schedulers.io()).blockingSingle()!!)
            return data
        }
    }

}


