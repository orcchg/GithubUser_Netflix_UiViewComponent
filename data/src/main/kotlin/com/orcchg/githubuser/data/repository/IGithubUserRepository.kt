package com.orcchg.githubuser.data.repository

import com.orcchg.githubuser.domain.model.GithubUser
import io.reactivex.Single

interface IGithubUserRepository {

    fun users(): Single<List<GithubUser>>

    fun user(login: String): Single<GithubUser>
}
