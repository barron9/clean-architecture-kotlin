package com

import com.di.DaggerAppComp
import com.models.DataCacheFactory
import javax.inject.Inject

class View { // javafx window

    //add observers to get response back from viemodels methods
    // (single <T>'s or observable<T> 's from domain-interops )

    //add viemodel factory

    //call viewmodel methods upon user interaction

    //add oberservers which observes the UI/user interaction
    @Inject
    lateinit var dcf:DataCacheFactory


init {
    DaggerAppComp.create().inject(this)
    dcf.getCar().subscribe(::println)
}
}