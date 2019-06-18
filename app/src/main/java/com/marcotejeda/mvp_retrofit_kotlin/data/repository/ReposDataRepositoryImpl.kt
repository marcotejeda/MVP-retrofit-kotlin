package com.marcotejeda.mvp_retrofit_kotlin.data.repository

import com.marcotejeda.mvp_retrofit_kotlin.data.datasourse.ReposDataStoreFactory
import com.marcotejeda.mvp_retrofit_kotlin.data.mapper.ReposDataMapper
import com.marcotejeda.mvp_retrofit_kotlin.domain.callback.ReposCallback
import com.marcotejeda.mvp_retrofit_kotlin.domain.callback.RepositoryCallback
import com.marcotejeda.mvp_retrofit_kotlin.domain.model.RepoModel

class ReposDataRepositoryImpl: ReposDataRepository {

    private var dataMapper: ReposDataMapper
    private var dataStoreFactory: ReposDataStoreFactory

    constructor(dataStoreFactory: ReposDataStoreFactory, dataMapper: ReposDataMapper) {
        this.dataStoreFactory = dataStoreFactory
        this.dataMapper = dataMapper
    }

    override fun loadReposioriesDataRepository(callback: ReposCallback) {

        val dataStore = dataStoreFactory.create(dataStoreFactory.REST)

        dataStore.loadRepositoriesDataStore(object: RepositoryCallback {
            override fun onSuccess(obj: Any?) {
                if(obj != null) {
                    callback.onRepositoriesSuccess(dataMapper.transformResponse(obj))
                }
            }

            override fun onError(obj: Any?) {
                if(obj != null) {
                    callback.onRepositoriesError(obj.toString())
                }
            }

        })
    }

}