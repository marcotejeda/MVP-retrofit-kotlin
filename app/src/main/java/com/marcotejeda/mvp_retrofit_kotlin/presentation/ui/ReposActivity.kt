package com.marcotejeda.mvp_retrofit_kotlin.presentation.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import com.marcotejeda.mvp_retrofit_kotlin.R
import com.marcotejeda.mvp_retrofit_kotlin.domain.model.RepoModel
import com.marcotejeda.mvp_retrofit_kotlin.presentation.adapter.ReposAdapter
import com.marcotejeda.mvp_retrofit_kotlin.presentation.presenter.ReposPresenterImpl
import com.marcotejeda.mvp_retrofit_kotlin.presentation.presenter.ReposPresenter
import com.marcotejeda.mvp_retrofit_kotlin.presentation.view.ReposView
import kotlinx.android.synthetic.main.activity_repos.*

class ReposActivity : BaseActivity(), ReposView {

    private lateinit var presenter: ReposPresenter
    private lateinit var adapter: ReposAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repos)

        presenter = ReposPresenterImpl()
        presenter.addView(this)

        btnGetRepositories.setOnClickListener {
            presenter.loadRepositoriesPresenter()
        }
    }

    override fun renderListView(result: ArrayList<RepoModel>) {
        adapter = ReposAdapter(this, result)
        lvRepositories.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun getContext(): Context {
        return this
    }

    override fun showProgressBar() {
        setProgressBar(flProgressBar, true)
    }

    override fun hideProgressBar() {
        setProgressBar(flProgressBar, false)
    }

    override fun showErrorMessage(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }
}
