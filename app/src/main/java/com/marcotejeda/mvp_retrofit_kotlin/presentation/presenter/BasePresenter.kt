package com.marcotejeda.mvp_retrofit_kotlin.presentation.presenter

interface BasePresenter<V> {
    fun addView(view: V)
    fun removeView()
}