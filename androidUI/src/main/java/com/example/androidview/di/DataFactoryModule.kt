package com.di

import android.content.Context
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
class AppPull {
    //  @Binds
    // fun bindApplication(app: App):Application

}

@Module
class AppModule(val application: Context) {

    @Provides
    fun provideApplication(): Context {
        return application
    }
}

@Module
class Persistence {

    @Singleton
    @Provides
    fun provideRoomDB(app: Context): CarDatabase {
        return Room.databaseBuilder(app, CarDatabase::class.java, "CarDatabase")
            .build()
    }

}

