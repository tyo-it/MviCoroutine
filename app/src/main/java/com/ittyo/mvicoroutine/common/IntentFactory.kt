package com.ittyo.mvicoroutine.common

interface IntentFactory<E> {
    suspend fun process(viewEvent: E)
}