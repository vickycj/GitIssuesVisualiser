package com.vicky.apps.datapoints.ui.viewmodel

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.vicky.apps.datapoints.common.SchedulerProvider
import com.vicky.apps.datapoints.data.remote.Repository
import com.vicky.apps.datapoints.ui.model.Issue

import io.reactivex.Single
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {


    @Mock
    lateinit var repository: Repository

    private val schedulerProvider = SchedulerProvider(Schedulers.trampoline(), Schedulers.trampoline())

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = MainViewModel(repository, schedulerProvider)
    }

    @After
    fun tearDown() {
    }


    fun getObject(): List<Issue>{
        val token = object : TypeToken<List<Issue>>() {

        }
        val jsonData = "[{\n" +
                "    \"url\": \"https://api.github.com/repos/square/okhttp/issues/5960\",\n" +
                "    \"repository_url\": \"https://api.github.com/repos/square/okhttp\",\n" +
                "    \"labels_url\": \"https://api.github.com/repos/square/okhttp/issues/5960/labels{/name}\",\n" +
                "    \"comments_url\": \"https://api.github.com/repos/square/okhttp/issues/5960/comments\",\n" +
                "    \"events_url\": \"https://api.github.com/repos/square/okhttp/issues/5960/events\",\n" +
                "    \"html_url\": \"https://github.com/square/okhttp/pull/5960\",\n" +
                "    \"id\": 602415850,\n" +
                "    \"node_id\": \"MDExOlB1bGxSZXF1ZXN0NDA1NDcwMTIz\",\n" +
                "    \"number\": 5960,\n" +
                "    \"title\": \"Test which TrustManager method called on Android\",\n" +
                "    \"user\": {\n" +
                "      \"login\": \"yschimke\",\n" +
                "      \"id\": 231923,\n" +
                "      \"node_id\": \"MDQ6VXNlcjIzMTkyMw==\",\n" +
                "      \"avatar_url\": \"https://avatars1.githubusercontent.com/u/231923?v=4\",\n" +
                "      \"gravatar_id\": \"\",\n" +
                "      \"url\": \"https://api.github.com/users/yschimke\",\n" +
                "      \"html_url\": \"https://github.com/yschimke\",\n" +
                "      \"followers_url\": \"https://api.github.com/users/yschimke/followers\",\n" +
                "      \"following_url\": \"https://api.github.com/users/yschimke/following{/other_user}\",\n" +
                "      \"gists_url\": \"https://api.github.com/users/yschimke/gists{/gist_id}\",\n" +
                "      \"starred_url\": \"https://api.github.com/users/yschimke/starred{/owner}{/repo}\",\n" +
                "      \"subscriptions_url\": \"https://api.github.com/users/yschimke/subscriptions\",\n" +
                "      \"organizations_url\": \"https://api.github.com/users/yschimke/orgs\",\n" +
                "      \"repos_url\": \"https://api.github.com/users/yschimke/repos\",\n" +
                "      \"events_url\": \"https://api.github.com/users/yschimke/events{/privacy}\",\n" +
                "      \"received_events_url\": \"https://api.github.com/users/yschimke/received_events\",\n" +
                "      \"type\": \"User\",\n" +
                "      \"site_admin\": false\n" +
                "    },\n" +
                "    \"labels\": [\n" +
                "\n" +
                "    ],\n" +
                "    \"state\": \"open\",\n" +
                "    \"locked\": false,\n" +
                "    \"assignee\": null,\n" +
                "    \"assignees\": [\n" +
                "\n" +
                "    ],\n" +
                "    \"milestone\": null,\n" +
                "    \"comments\": 0,\n" +
                "    \"created_at\": \"2020-04-18T09:09:31Z\",\n" +
                "    \"updated_at\": \"2020-04-18T09:09:31Z\",\n" +
                "    \"closed_at\": null,\n" +
                "    \"author_association\": \"COLLABORATOR\",\n" +
                "    \"pull_request\": {\n" +
                "      \"url\": \"https://api.github.com/repos/square/okhttp/pulls/5960\",\n" +
                "      \"html_url\": \"https://github.com/square/okhttp/pull/5960\",\n" +
                "      \"diff_url\": \"https://github.com/square/okhttp/pull/5960.diff\",\n" +
                "      \"patch_url\": \"https://github.com/square/okhttp/pull/5960.patch\"\n" +
                "    },\n" +
                "    \"body\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"url\": \"https://api.github.com/repos/square/okhttp/issues/5959\",\n" +
                "    \"repository_url\": \"https://api.github.com/repos/square/okhttp\",\n" +
                "    \"labels_url\": \"https://api.github.com/repos/square/okhttp/issues/5959/labels{/name}\",\n" +
                "    \"comments_url\": \"https://api.github.com/repos/square/okhttp/issues/5959/comments\",\n" +
                "    \"events_url\": \"https://api.github.com/repos/square/okhttp/issues/5959/events\",\n" +
                "    \"html_url\": \"https://github.com/square/okhttp/pull/5959\",\n" +
                "    \"id\": 602154035,\n" +
                "    \"node_id\": \"MDExOlB1bGxSZXF1ZXN0NDA1Mjc2MzE3\",\n" +
                "    \"number\": 5959,\n" +
                "    \"title\": \"Use Android API for NetworkSecurityPolicy\",\n" +
                "    \"user\": {\n" +
                "      \"login\": \"yschimke\",\n" +
                "      \"id\": 231923,\n" +
                "      \"node_id\": \"MDQ6VXNlcjIzMTkyMw==\",\n" +
                "      \"avatar_url\": \"https://avatars1.githubusercontent.com/u/231923?v=4\",\n" +
                "      \"gravatar_id\": \"\",\n" +
                "      \"url\": \"https://api.github.com/users/yschimke\",\n" +
                "      \"html_url\": \"https://github.com/yschimke\",\n" +
                "      \"followers_url\": \"https://api.github.com/users/yschimke/followers\",\n" +
                "      \"following_url\": \"https://api.github.com/users/yschimke/following{/other_user}\",\n" +
                "      \"gists_url\": \"https://api.github.com/users/yschimke/gists{/gist_id}\",\n" +
                "      \"starred_url\": \"https://api.github.com/users/yschimke/starred{/owner}{/repo}\",\n" +
                "      \"subscriptions_url\": \"https://api.github.com/users/yschimke/subscriptions\",\n" +
                "      \"organizations_url\": \"https://api.github.com/users/yschimke/orgs\",\n" +
                "      \"repos_url\": \"https://api.github.com/users/yschimke/repos\",\n" +
                "      \"events_url\": \"https://api.github.com/users/yschimke/events{/privacy}\",\n" +
                "      \"received_events_url\": \"https://api.github.com/users/yschimke/received_events\",\n" +
                "      \"type\": \"User\",\n" +
                "      \"site_admin\": false\n" +
                "    },\n" +
                "    \"labels\": [\n" +
                "\n" +
                "    ],\n" +
                "    \"state\": \"open\",\n" +
                "    \"locked\": false,\n" +
                "    \"assignee\": null,\n" +
                "    \"assignees\": [\n" +
                "\n" +
                "    ],\n" +
                "    \"milestone\": null,\n" +
                "    \"comments\": 0,\n" +
                "    \"created_at\": \"2020-04-17T18:22:52Z\",\n" +
                "    \"updated_at\": \"2020-04-17T18:35:45Z\",\n" +
                "    \"closed_at\": null,\n" +
                "    \"author_association\": \"COLLABORATOR\",\n" +
                "    \"pull_request\": {\n" +
                "      \"url\": \"https://api.github.com/repos/square/okhttp/pulls/5959\",\n" +
                "      \"html_url\": \"https://github.com/square/okhttp/pull/5959\",\n" +
                "      \"diff_url\": \"https://github.com/square/okhttp/pull/5959.diff\",\n" +
                "      \"patch_url\": \"https://github.com/square/okhttp/pull/5959.patch\"\n" +
                "    },\n" +
                "    \"body\": \"\"\n" +
                "  }]"
        val gson = Gson()
        return gson.fromJson(jsonData,token.type)

    }



    @Test
    fun getDataFromRemote() {

        Mockito.`when`(repository.fetchIssuesFromRepo("square","okhttp")).thenReturn(Single.just(getObject()))

        val testObserver = TestObserver<List<Issue>>()

        viewModel.fetchIssuesFromViewModel("square","okhttp")
            .subscribe(testObserver)

        testObserver.assertNoErrors()
        testObserver.assertValue { responseData -> responseData.size == 2 }
    }




}