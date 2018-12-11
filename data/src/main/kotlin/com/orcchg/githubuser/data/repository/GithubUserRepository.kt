package com.orcchg.githubuser.data.repository

import com.orcchg.githubuser.data.remote.GithubCloud
import com.orcchg.githubuser.domain.model.GithubUser
import io.reactivex.Single

class GithubUserRepository(private val cloud: GithubCloud) {

    fun users(): Single<List<GithubUser>> = cloud.users()

    fun user(login: String): Single<GithubUser> = cloud.user(login)
}
