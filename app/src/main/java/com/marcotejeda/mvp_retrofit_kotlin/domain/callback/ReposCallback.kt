package com.marcotejeda.mvp_retrofit_kotlin.domain.callback

import com.marcotejeda.mvp_retrofit_kotlin.domain.model.RepoModel

interface ReposCallback {
    fun onRepositoriesSuccess(list: ArrayList<RepoModel>)
    fun onRepositoriesError(error: String)
}