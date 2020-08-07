package com.ittyo.mvicoroutine.common

interface Intent<T> {
    fun reduce(oldState: T): T
}