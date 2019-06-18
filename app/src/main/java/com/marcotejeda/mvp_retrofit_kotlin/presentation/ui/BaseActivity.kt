package com.marcotejeda.mvp_retrofit_kotlin.presentation.ui

import android.support.v7.app.AppCompatActivity
import android.view.View

open class BaseActivity : AppCompatActivity() {

    protected fun setProgressBar(view: View, show: Boolean) {
        if (show) view.visibility = View.VISIBLE else view.visibility = View.GONE
    }
}
