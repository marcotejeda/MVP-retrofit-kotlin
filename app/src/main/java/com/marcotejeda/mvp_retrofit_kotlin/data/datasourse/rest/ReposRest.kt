package com.marcotejeda.mvp_retrofit_kotlin.data.datasourse.rest


import com.marcotejeda.mvp_retrofit_kotlin.data.datasourse.ReposDataStore
import com.marcotejeda.mvp_retrofit_kotlin.data.entity.RepoResponse
import com.marcotejeda.mvp_retrofit_kotlin.domain.callback.RepositoryCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReposRest: ReposDataStore {

    private var call: Call<List<RepoResponse>>? = null

    override fun loadRepositoriesDataStore(callback: RepositoryCallback) {
        call = ApiClient.buildApiServices()?.getRepositories()
        call?.enqueue(object: Callback<List<RepoResponse>> {

            override fun onFailure(call: Call<List<RepoResponse>>, t: Throwable) {
                callback.onError(t.message)
            }

            override fun onResponse(call: Call<List<RepoResponse>>, response: Response<List<RepoResponse>>) {
                if(response.isSuccessful){
                    callback.onSuccess(response.body())
                } else {
                    callback.onError(response.message())
                }
            }

        })
    }

}