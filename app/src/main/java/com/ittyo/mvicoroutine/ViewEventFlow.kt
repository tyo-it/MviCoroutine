package com.ittyo.mvicoroutine

import kotlinx.coroutines.flow.Flow

interface ViewEventFlow<E> {
    fun viewEvents(): Flow<E>
}