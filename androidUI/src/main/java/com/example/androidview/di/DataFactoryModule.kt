package com.di

import android.app.Application
import androidx.room.Room
import com.cachedata.DataCacheFactory
import com.example.androidview.persistance.CarDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import interfaces.DataInterface
import javax.inject.Singleton

@Module
abstract class DataFactoryModule {
    @Binds
    @Singleton
    abstract fun bindDataFactory(dcf: DataCacheFactory): DataInterface

}

@Module
class Persistence {
    lateinit var applicationContext: Application

    @Singleton
    @Provides
    fun provideRoomDB(): CarDatabase {
        return Room.databaseBuilder(applicationContext, CarDatabase::class.java, "CarDatabase")
            .build()
    }
}

