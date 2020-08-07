package com.ittyo.mvicoroutine.mainview.model

import com.ittyo.mvicoroutine.common.Intent
import com.ittyo.mvicoroutine.common.ModelStore
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

object UpvoteModelStore: ModelStore<UpvoteModel> {
    private val startingState = UpvoteModel(0, 0)
    private val intents = Channel<Intent<UpvoteModel>>()
    private val store = ConflatedBroadcastChannel(startingState)
    private val scope = MainScope()

    init {
        scope.launch {
            while (isActive) {
                store.offer(intents.receive().reduce(store.value))
            }
        }
    }

    override fun process(intent: Intent<UpvoteModel>) {
        intents.offer(intent)
    }

    override fun modelState(): Flow<UpvoteModel> {
        return store.asFlow()
    }
}