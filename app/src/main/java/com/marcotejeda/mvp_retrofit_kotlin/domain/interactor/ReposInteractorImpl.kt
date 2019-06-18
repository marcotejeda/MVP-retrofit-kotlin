package com.marcotejeda.mvp_retrofit_kotlin.domain.interactor

import android.content.Context
import com.marcotejeda.mvp_retrofit_kotlin.data.datasourse.ReposDataStoreFactory
import com.marcotejeda.mvp_retrofit_kotlin.data.mapper.ReposDataMapper
import com.marcotejeda.mvp_retrofit_kotlin.data.repository.ReposDataRepositoryImpl
import com.marcotejeda.mvp_retrofit_kotlin.domain.callback.ReposCallback


class ReposInteractorImpl: ReposInteractor{

    private var context: Context
    private var dataStoreFactory: ReposDataStoreFactory
    private var dataMapper: ReposDataMapper
    private var dataRepositoryImpl: ReposDataRepositoryImpl


    constructor(context: Context){
        this.context = context
        this.dataStoreFactory = ReposDataStoreFactory(this.context)
        this.dataMapper = ReposDataMapper()
        this.dataRepositoryImpl = ReposDataRepositoryImpl(dataStoreFactory, dataMapper)
    }

    override fun loadRepositoriesInteractor(callback: ReposCallback) {
        dataRepositoryImpl.loadReposioriesDataRepository(callback)
    }


}