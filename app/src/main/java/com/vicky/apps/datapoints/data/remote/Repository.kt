package com.vicky.apps.datapoints.data.remote

import com.vicky.apps.datapoints.ui.model.Issue
import io.reactivex.Single

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val apiService: ApiService) {

    fun fetchIssuesFromRepo(owner:String, repo:String): Single<List<Issue>> = apiService.fetchIssues(owner, repo)

}