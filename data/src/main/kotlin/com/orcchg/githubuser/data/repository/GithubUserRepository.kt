package com.orcchg.githubuser.data.repository

import com.orcchg.githubuser.data.remote.GithubCloud
import com.orcchg.githubuser.domain.model.User
import io.reactivex.Single

class GithubUserRepository(private val cloud: GithubCloud) {

    fun users(): Single<List<User>> = cloud.users()

    fun user(login: String): Single<User> = cloud.user(login)
}
