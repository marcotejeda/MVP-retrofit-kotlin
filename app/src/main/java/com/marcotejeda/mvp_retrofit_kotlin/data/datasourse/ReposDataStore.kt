package com.marcotejeda.mvp_retrofit_kotlin.data.datasourse

import com.marcotejeda.mvp_retrofit_kotlin.domain.callback.RepositoryCallback

interface ReposDataStore {
    fun loadRepositoriesDataStore(callback: RepositoryCallback)
}