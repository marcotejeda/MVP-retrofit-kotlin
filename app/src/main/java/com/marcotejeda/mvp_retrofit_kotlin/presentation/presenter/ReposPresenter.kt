package com.marcotejeda.mvp_retrofit_kotlin.presentation.presenter

import com.marcotejeda.mvp_retrofit_kotlin.presentation.view.ReposView

interface ReposPresenter: BasePresenter<ReposView> {
    fun loadRepositoriesPresenter()
}