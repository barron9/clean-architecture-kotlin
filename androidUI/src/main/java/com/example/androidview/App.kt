package com.example.androidview

import android.app.Application
import javax.inject.Inject

class App @Inject constructor() : Application() {

    var navCont = Coordinator(getAppContext())

    fun getAppContext(): Application {
        return this;
    }

    fun getCoordinator(): Coordinator {
        return navCont;
    }
}