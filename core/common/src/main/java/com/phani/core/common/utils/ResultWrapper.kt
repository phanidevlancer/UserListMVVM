package com.phani.core.common.utils


sealed class ResultWrapper<out T> {
    data class Success<out T>(val data: T) : ResultWrapper<T>()
    data class Error(val exception: Throwable) : ResultWrapper<Nothing>()
    data object Loading : ResultWrapper<Nothing>()

    companion object {
        fun <T> success(data : T) = Success(data)
        fun error(exception: Throwable) = Error(exception)
        fun loading() : ResultWrapper<Nothing> = Loading
    }

}