package com.di

import com.barron.View
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UseCaseModule::class,DataFactoryModule::class,NetworkModule::class])
interface AppComp {
    fun inject(view: View)
}