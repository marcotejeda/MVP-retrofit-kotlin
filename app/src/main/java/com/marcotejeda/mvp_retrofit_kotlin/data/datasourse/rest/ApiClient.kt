package com.marcotejeda.mvp_retrofit_kotlin.data.datasourse.rest


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    fun buildApiServices(): ApiServicesInterface? {

        var retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ApiServicesInterface::class.java)
    }

}

