package com.models

import javax.inject.Inject

class CarData @Inject constructor() {
    private var name:String

    init {
        this.name = "mazda 1998 coupé"
    }

    fun get():String{
        return String().plus(this.name)
    }

    fun set(name:String){
        this.name = name;
    }

    override fun toString():String{
        return this.get()
    }

}