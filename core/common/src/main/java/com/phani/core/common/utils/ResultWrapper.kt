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

    inline fun <R> map(transfrom : (T) -> R) : ResultWrapper<R> {
        return when(this) {
            is Success -> Success(transfrom(data))
            is Error -> Error(exception)
            is Loading -> Loading
        }
    }

    fun getOrNull() : T? = when(this) {
        is Success -> data
        else -> null
    }

    fun isSuccess() : Boolean = this is Success

    fun isError() : Boolean = this is Error

    fun isLoading() : Boolean = this is Loading
}