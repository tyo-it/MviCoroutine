package com.ittyo.mvicoroutine.common

import android.view.View
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

fun View.clicks(): Flow<Unit> = callbackFlow {
    val listener = View.OnClickListener { offer(Unit) }
    setOnClickListener { listener }
    awaitClose {
        setOnClickListener(null)
    }
}