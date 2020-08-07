package com.ittyo.mvicoroutine.mainview.view

sealed class MainViewEvent {
    object ThumbsUpClick: MainViewEvent()
    object LoveItClick: MainViewEvent()
}