package com.vicky.apps.datapoints.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vicky.apps.datapoints.base.Error
import com.vicky.apps.datapoints.base.ResultType
import com.vicky.apps.datapoints.base.Success
import com.vicky.apps.datapoints.common.SchedulerProvider
import com.vicky.apps.datapoints.data.remote.Repository
import com.vicky.apps.datapoints.ui.model.Issue
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy


class MainViewModel(
    private val repository: Repository,
    private val schedulerProvider: SchedulerProvider
) : ViewModel() {


    private var dataList: List<Issue> = ArrayList()


    private val response: MutableLiveData<ResultType> = MutableLiveData<ResultType>()

    fun getSubscription(): MutableLiveData<ResultType> = response

    private lateinit var compositeDisposable: CompositeDisposable

    fun getDataList(): List<Issue> = dataList

    private var ascendingVal: Boolean = false

    fun setCompositeData(compositeDisposable: CompositeDisposable) {
        this.compositeDisposable = compositeDisposable
    }


    fun getDataFromRemote(owner: String, repo: String) {

        if (dataList.isNotEmpty()) {
            response.postValue(Success())
            return
        }
        compositeDisposable.add(fetchIssuesFromViewModel(owner, repo).subscribeBy(onSuccess = {
            dataList = it
            response.postValue(Success())
        }, onError = {
            Log.d("valuessss", it.message)
            response.postValue(Error("error"))
        }))


    }

    fun fetchIssuesFromViewModel(owner: String, repo: String): Single<List<Issue>> {
        return repository.fetchIssuesFromRepo(owner, repo)
            .compose(schedulerProvider.getSchedulersForSingle())
    }


}