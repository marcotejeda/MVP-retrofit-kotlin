package com.marcotejeda.mvp_retrofit_kotlin.presentation.presenter


import com.marcotejeda.mvp_retrofit_kotlin.domain.callback.ReposCallback
import com.marcotejeda.mvp_retrofit_kotlin.domain.interactor.ReposInteractor
import com.marcotejeda.mvp_retrofit_kotlin.domain.interactor.ReposInteractorImpl
import com.marcotejeda.mvp_retrofit_kotlin.domain.model.RepoModel
import com.marcotejeda.mvp_retrofit_kotlin.presentation.view.ReposView


class ReposPresenterImpl: ReposPresenter, ReposCallback {

    private var reposView: ReposView? = null
    private lateinit var interactor: ReposInteractor

    override fun addView(view: ReposView) {
        this.reposView = view
        interactor = ReposInteractorImpl(reposView!!.getContext())
    }

    override fun removeView() {
        this.reposView = null
    }

    override fun loadRepositoriesPresenter() {
        if (reposView != null) {
            reposView?.showProgressBar()
            interactor.loadRepositoriesInteractor(this)
        }
    }

    override fun onRepositoriesSuccess(list: ArrayList<RepoModel>) {
        if (reposView != null) {
            reposView?.hideProgressBar()
            reposView?.renderListView(list)
        }
    }

    override fun onRepositoriesError(error: String) {
        if (reposView != null) {
            reposView?.hideProgressBar()
            reposView?.showErrorMessage(error)
        }
    }
}