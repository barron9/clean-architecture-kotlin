package com.di

import com.example.androidview.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UseCaseModule::class,DataFactoryModule::class,NetworkModule::class])
interface AppComp {
    fun inject(view: MainActivity)
}