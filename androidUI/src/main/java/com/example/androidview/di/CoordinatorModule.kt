package com.example.androidview.di

import android.app.Application
import com.example.androidview.App
import com.example.androidview.Coordinator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoordinatorModule {

    @Singleton
    var applicationContext: Application = App()

    @Provides
    @Singleton
    fun provideCoordinator(): Coordinator {
        return Coordinator(app = applicationContext)
    }
}