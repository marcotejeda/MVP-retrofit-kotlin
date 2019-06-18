package com.marcotejeda.mvp_retrofit_kotlin.data.datasourse

import android.content.Context
import com.marcotejeda.mvp_retrofit_kotlin.data.datasourse.db.ReposDB
import com.marcotejeda.mvp_retrofit_kotlin.data.datasourse.prefrerences.ReposPreferences
import com.marcotejeda.mvp_retrofit_kotlin.data.datasourse.rest.ReposRest

class ReposDataStoreFactory {

    val DB = 0
    val PREFERENCES = 1
    val REST = 2

    private val context: Context

    constructor(context: Context) {
        this.context = context.applicationContext
    }

    fun create(datasourse: Int): ReposDataStore {
        var dataStore: ReposDataStore? = null

        when(datasourse) {
            0 -> dataStore = ReposDB()
            1 -> dataStore = ReposPreferences()
            2 -> dataStore = ReposRest()
        }

        return dataStore as ReposDataStore
    }
}