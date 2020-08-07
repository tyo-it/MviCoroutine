package com.ittyo.mvicoroutine.mainview.intent

import com.ittyo.mvicoroutine.common.Intent
import com.ittyo.mvicoroutine.common.IntentFactory
import com.ittyo.mvicoroutine.mainview.model.UpvoteModel
import com.ittyo.mvicoroutine.mainview.model.UpvoteModelStore
import com.ittyo.mvicoroutine.mainview.view.MainViewEvent

object MainViewIntentFactory: IntentFactory<MainViewEvent> {
    override suspend fun process(viewEvent: MainViewEvent) {
        UpvoteModelStore.process(toIntent(viewEvent))
    }

    private fun toIntent(viewEvent: MainViewEvent): Intent<UpvoteModel> {
        return when (viewEvent) {
            MainViewEvent.LoveItClick -> AddHeart()
            MainViewEvent.ThumbsUpClick -> AddThumb()
        }
    }
}