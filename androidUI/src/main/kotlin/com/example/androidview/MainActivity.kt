package com.example.androidview

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cachedata.DataCacheFactory
import com.di.DaggerAppComp
import com.example.androidview.databinding.ActivityMainBinding
import entities.Car
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import usecases.DefaultUseCase
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var dcf: DataCacheFactory

    @Inject
    lateinit var duc: DefaultUseCase
    private lateinit var bindingMain: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        DaggerAppComp.create().inject(this)
        setContentView(bindingMain.root)

        present()
    }

    @SuppressLint("CheckResult")
    fun present(){
        dcf.getCar()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::consume)
        duc.exec()
    }

    private fun consume(car: Car){
       bindingMain.postmsg.text = car.name
    }
}