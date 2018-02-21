package io.github.karageageta.network.helper

enum class WatchStatus(val kind: String, kindText: String) {
    WANNA_WATCH("wanna_watch", "見たい"),
    WATCHING("watching", "見てる"),
    WATCHED("watched", "見た"),
    ON_HOLD("on_hold", "中断"),
    STOP_WATCHING("stop_watching", "中止"),
    NO_SELECT("no_select", "未選択")
}