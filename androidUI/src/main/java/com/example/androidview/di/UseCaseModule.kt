package com.di


import dagger.Binds
import dagger.Module
import interfaces.UsecaseExecutor
import usecases.DefaultUseCase
import javax.inject.Singleton

@Module
abstract class UseCaseModule {
    @Binds
    @Singleton
    abstract fun bindUseCase(dusecase: DefaultUseCase): UsecaseExecutor
}