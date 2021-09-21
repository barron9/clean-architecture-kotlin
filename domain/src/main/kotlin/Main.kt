package com

import com.models.Car
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class CarModule {
    @Provides
    @Singleton
    fun providecar(): Car {
        return Car()
    }
}
@Singleton
@Component(modules = [CarModule::class])
interface AppComp {
    fun getcar():Car
    fun inject(page: Page)
}

class Page {
     @Inject
     lateinit var car: Car

    init {
        (DaggerAppComp.create().inject(this));
        print(car)
    }
}

fun main() {
    Page()
}