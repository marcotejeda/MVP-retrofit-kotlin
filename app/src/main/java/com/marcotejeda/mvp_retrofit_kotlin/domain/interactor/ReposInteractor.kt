package com.marcotejeda.mvp_retrofit_kotlin.domain.interactor

import com.marcotejeda.mvp_retrofit_kotlin.domain.callback.ReposCallback

interface ReposInteractor {
    fun loadRepositoriesInteractor(callback: ReposCallback)
}