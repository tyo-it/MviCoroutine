package com.ittyo.mvicoroutine.mainview.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ittyo.mvicoroutine.R
import com.ittyo.mvicoroutine.common.ViewEventFlow
import com.ittyo.mvicoroutine.common.clicks
import kotlinx.android.synthetic.main.fragment_thumbs_love.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flattenMerge
import kotlinx.coroutines.flow.map

class ThumbsLoveFragment : Fragment(),
    ViewEventFlow<MainViewEvent> {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_thumbs_love, container, false)
    }

    override fun viewEvents(): Flow<MainViewEvent> {
        val events = listOf(
            loveBtn.clicks().map { MainViewEvent.LoveItClick },
            thumbsBtn.clicks().map { MainViewEvent.ThumbsUpClick }
        )
        return events.asFlow().flattenMerge(events.size)
    }

}