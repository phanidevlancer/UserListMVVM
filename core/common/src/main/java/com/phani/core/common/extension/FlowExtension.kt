package com.phani.core.common.extension

import com.phani.core.common.utils.ResultWrapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

fun <T> Flow<T>.asResult(): Flow<ResultWrapper<T>> {
    return this
        .map<T, ResultWrapper<T>> { ResultWrapper.Success(it) }
        .onStart { emit(ResultWrapper.loading()) }
        .catch { emit(ResultWrapper.error(it)) }
}