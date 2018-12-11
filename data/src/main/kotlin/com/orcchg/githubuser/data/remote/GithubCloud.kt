package com.orcchg.githubuser.data.remote

import com.orcchg.githubuser.domain.model.GithubUser
import io.reactivex.Single

class GithubCloud(private val restAdapter: GithubRestAdapter) {

    fun users(): Single<List<GithubUser>> = restAdapter.users()

    fun user(login: String): Single<GithubUser> = restAdapter.user(login)
}
