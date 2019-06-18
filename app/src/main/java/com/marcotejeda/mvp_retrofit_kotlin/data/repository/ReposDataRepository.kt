package com.marcotejeda.mvp_retrofit_kotlin.data.repository

import com.marcotejeda.mvp_retrofit_kotlin.domain.callback.ReposCallback

interface ReposDataRepository {
    fun loadReposioriesDataRepository(callback: ReposCallback)
}