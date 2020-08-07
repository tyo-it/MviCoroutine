package com.ittyo.mvicoroutine.mainview.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.ittyo.mvicoroutine.R
import com.ittyo.mvicoroutine.common.ViewEventFlow
import com.ittyo.mvicoroutine.common.clicks
import com.ittyo.mvicoroutine.mainview.intent.MainViewIntentFactory
import com.ittyo.mvicoroutine.mainview.model.UpvoteModelStore
import kotlinx.android.synthetic.main.fragment_thumbs_love.*
import kotlinx.coroutines.flow.*

class ThumbsLoveFragment : Fragment(), ViewEventFlow<MainViewEvent> {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_thumbs_love, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewEvents()
            .onEach { viewEvents -> MainViewIntentFactory.process(viewEvents) }
            .launchIn(lifecycleScope)

        UpvoteModelStore
            .modelState()
            .onEach { model ->
                Log.d("model", "$model")
                loveCount.text = model.hearts.toString()
                thumbsCount.text = model.thumbs.toString()
            }.launchIn(lifecycleScope)
    }

    override fun viewEvents(): Flow<MainViewEvent> {
        val events = listOf(
            loveBtn.clicks().map { MainViewEvent.LoveItClick },
            thumbsBtn.clicks().map { MainViewEvent.ThumbsUpClick }
        )
        return events.asFlow().flattenMerge(events.size)
    }
}