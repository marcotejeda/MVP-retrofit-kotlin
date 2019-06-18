package com.marcotejeda.mvp_retrofit_kotlin.presentation.view

import android.content.Context

interface BaseView {
    fun getContext(): Context
    fun showProgressBar()
    fun hideProgressBar()
    fun showErrorMessage(error: String)
}