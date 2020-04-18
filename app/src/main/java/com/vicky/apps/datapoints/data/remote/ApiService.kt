package com.vicky.apps.datapoints.data.remote


import com.vicky.apps.datapoints.ui.model.Issue
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {
    @GET("repos/{owner}/{repo}/issues")
    fun fetchIssues(@Path("owner") owner:String,@Path("repo") repo:String ): Single<List<Issue>>
}
