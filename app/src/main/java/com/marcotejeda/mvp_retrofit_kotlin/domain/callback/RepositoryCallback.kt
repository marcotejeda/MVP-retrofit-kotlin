package com.marcotejeda.mvp_retrofit_kotlin.domain.callback

interface RepositoryCallback {
    fun onSuccess(obj: Any?)
    fun onError(obj: Any?)
}