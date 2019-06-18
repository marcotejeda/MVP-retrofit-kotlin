package com.marcotejeda.mvp_retrofit_kotlin.data.mapper

import com.marcotejeda.mvp_retrofit_kotlin.data.entity.RepoResponse
import com.marcotejeda.mvp_retrofit_kotlin.domain.model.RepoModel

class ReposDataMapper {

    fun transformResponse(obj: Any?) : ArrayList<RepoModel> {
        val repos = ArrayList<RepoModel>()
        val list = obj as List<*>

        for (repo in list) {
            repos.add(transform(repo as RepoResponse?))
        }

        return repos
    }

    private fun transform(r: RepoResponse?): RepoModel {
        return RepoModel(r!!.full_name)
    }

}

