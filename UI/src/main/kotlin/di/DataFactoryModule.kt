package com.di

import com.cachedata.DataCacheFactory
import dagger.Binds
import dagger.Module
import interfaces.DataInterface
import interfaces.NetworkInterface
import network.APIService
import javax.inject.Singleton

@Module
abstract class DataFactoryModule {
    @Binds
    @Singleton
    abstract fun bindDataFactory(dcf: DataCacheFactory): DataInterface
}

@Module
abstract class NetworkModule {
    @Binds
    @Singleton
    abstract fun bindAPIService(api: APIService): NetworkInterface
}