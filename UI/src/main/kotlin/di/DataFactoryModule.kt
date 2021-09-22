package com.di

import com.cachedata.DataCacheFactory
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