package com.di

import com.View
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UseCaseModule::class,DataFactoryModule::class])
interface AppComp {
    fun inject(view: View)
}