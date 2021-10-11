package com.example.androidview.features.CarListings

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.example.androidview.repository.AppRepository
import entities.CarMake
import entities.CarResponse
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject
import javax.inject.Provider

class CLviewModelFactory @Inject constructor(val model: CarListingViewModel2) :
    ViewModelProvider.Factory {
    private val res = (model::class.java)
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return res as T
    }
}

class ViewModelFactory @Inject constructor(
    myViewModelProvider: Provider<CarListingViewModel2>
) : ViewModelProvider.Factory {

    private val providers = mapOf<Class<*>, Provider<out ViewModel>>(
        CarListingViewModel2::class.java to myViewModelProvider
    )

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return providers[modelClass]!!.get() as T
    }
}

class CarListingViewModel2
@Inject constructor(
    val repository: AppRepository
) : ViewModel() {
    val sync = MutableLiveData<String>()//repository.transactions().asLiveData() //flow to ld.
    val test = repository.db.getCars().asLiveData()
}

class CarListingViewModel
@Inject constructor(
    val repository: AppRepository
) : ViewModel() {

    // fun sync(q: String) = repository.transactions().asLiveData() //flow to ld.

    companion object {
        /*var dagger = DaggerAppComp.builder().build()
        val service: NetworkInterface = dagger.getNetwwork()
        var data: Observable<CarResponse?>? = service.GetMakeForManufacturer("a")*/
        var bs: BehaviorSubject<CarResponse?> = BehaviorSubject.create<CarResponse?>()
        var loader: BehaviorSubject<Boolean?> = BehaviorSubject.create<Boolean?>()
        var resultdata: MutableLiveData<List<CarMake>> = MutableLiveData<List<CarMake>>()

        @SuppressLint("CheckResult")
        fun call(q: String): BehaviorSubject<CarResponse?>? {
            Log.e("Pageviewmodel", Thread.currentThread().name)
            loader.onNext(true)
            /*   service.GetMakeForManufacturer(q)
                    .subscribe { s ->
                        bs.onNext(s!!)
                        loader.onNext(false)
                        resultdata.postValue(s.Results)

                        Log.e("Pageviewmodel", Thread.currentThread().name)
                    }*/
            return bs
        }

        fun result(o: CarResponse?) {
            Log.e("Pageviewmodel inresult", Thread.currentThread().name)
            bs.onNext(o!!)
        }
    }


}


