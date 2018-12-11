package com.orcchg.githubuser.data.remote

import com.orcchg.githubuser.domain.model.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubRestAdapter {

    @GET("users")
    fun users(): Single<List<User>>

    @GET("users/{login}")
    fun user(@Path("login") login: String): Single<User>
}
