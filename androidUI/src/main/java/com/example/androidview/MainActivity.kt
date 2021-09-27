package com.example.androidview

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.view.Menu
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.cachedata.DataCacheFactory
import com.example.androidview.databinding.ActivityMainBinding
import entities.Car
import entities.CarResponse
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
        // DaggerAppComp.create().inject(this)
        setContentView(bindingMain.root)
        if (Build.VERSION.SDK_INT > 9) {
            val policy: StrictMode.ThreadPolicy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }
        present()
    }

    @SuppressLint("CheckResult")
    fun present() {
//        dcf.getCar()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(::consume)
//        duc.exec()


    }

    private fun consume(car: Car) {
        // bindingMain.postmsg.text = car.name
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu, menu)
        val search = menu?.findItem(R.id.app_bar_search)
        val searchView = search?.actionView as SearchView
        searchView.maxWidth = Integer.MAX_VALUE
        searchView.queryHint = "type a car maker"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                if (!p0.isNullOrEmpty())
                    PagestartViewModel.call(p0)?.subscribeOn(Schedulers.io())?.subscribe()
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return true
            }

            fun myhandler(car: CarResponse?) {
                System.out.println("car res " + car?.Results)
            }

        })
        return true
    }
}