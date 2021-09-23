package com.cachedata

import entities.Car
import javax.inject.Inject

//Cache InMemory Mock-DB
class CarData @Inject constructor() {
    private var name:String

    init {
        this.name = "mazda 1998 coupé"
    }

    fun get(): Car {
        return Car(this.name)
    }

    fun set(name:String){
        this.name = name;
    }

    override fun toString():String{
        return String().plus(this.get())
    }

}