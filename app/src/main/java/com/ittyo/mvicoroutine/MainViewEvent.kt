package com.ittyo.mvicoroutine

sealed class MainViewEvent {
    object ThumbsUpClick: MainViewEvent()
    object LoveItClick: MainViewEvent()
}