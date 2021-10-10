package com.di

import com.example.androidview.features.CarListings.Page1ViewModel
import dagger.Component
import interfaces.NetworkInterface
import network.APIService
import javax.inject.Singleton

@Singleton
@Component(modules = [UseCaseModule::class, DataFactoryModule::class, NetworkModule::class])
abstract class AppComp {
    fun getNetwwork(): NetworkInterface {
        return APIService()
    }

    abstract fun inject(view: Page1ViewModel.Companion)
}