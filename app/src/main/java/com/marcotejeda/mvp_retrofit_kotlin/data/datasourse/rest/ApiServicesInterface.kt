package com.marcotejeda.mvp_retrofit_kotlin.data.datasourse.rest

import com.marcotejeda.mvp_retrofit_kotlin.data.entity.RepoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServicesInterface {

    @GET("users/marcotejeda/repos")
    fun getRepositories(): Call<List<RepoResponse>>
}