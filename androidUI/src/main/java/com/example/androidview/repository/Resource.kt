package com.example.androidview.repository

sealed class Resource<T> {
    class Success<T>(data: T?) : Resource<T>()
    class Loading<T>(data: T?) : Resource<T>()
    class Error<T>(throwable: Throwable, data: T?) : Resource<T>()
}