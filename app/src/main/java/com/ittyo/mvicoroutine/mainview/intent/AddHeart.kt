package com.ittyo.mvicoroutine.mainview.intent

import com.ittyo.mvicoroutine.common.Intent
import com.ittyo.mvicoroutine.mainview.model.UpvoteModel

class AddHeart: Intent<UpvoteModel> {
    override fun reduce(oldState: UpvoteModel): UpvoteModel {
        return oldState.copy(hearts = oldState.hearts + 1)
    }
}