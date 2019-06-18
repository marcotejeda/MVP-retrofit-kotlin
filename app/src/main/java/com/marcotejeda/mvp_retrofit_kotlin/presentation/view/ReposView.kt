package com.marcotejeda.mvp_retrofit_kotlin.presentation.view

import com.marcotejeda.mvp_retrofit_kotlin.domain.model.RepoModel

interface ReposView: BaseView {
    fun renderListView(result: ArrayList<RepoModel>)
}