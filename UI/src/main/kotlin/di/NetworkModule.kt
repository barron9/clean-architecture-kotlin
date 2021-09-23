package com.di

import dagger.Binds
import dagger.Module
import interfaces.NetworkInterface
import network.APIService
import javax.inject.Singleton

@Module
abstract class NetworkModule {
    @Binds
    @Singleton
    abstract fun bindAPIService(api: APIService): NetworkInterface
}