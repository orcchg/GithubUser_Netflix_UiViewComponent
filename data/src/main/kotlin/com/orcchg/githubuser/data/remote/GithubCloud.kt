package com.orcchg.githubuser.data.remote

import com.orcchg.githubuser.domain.model.User
import io.reactivex.Single

class GithubCloud(private val restAdapter: GithubRestAdapter) {

    fun users(): Single<List<User>> = restAdapter.users()

    fun user(login: String): Single<User> = restAdapter.user(login)
}
