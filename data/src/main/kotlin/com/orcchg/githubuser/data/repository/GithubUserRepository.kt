package com.orcchg.githubuser.data.repository

import com.orcchg.githubuser.data.local.GithubUserDao
import com.orcchg.githubuser.data.remote.GithubCloud
import com.orcchg.githubuser.domain.model.GithubUser
import com.orcchg.githubuser.domain.model.mapList
import com.orcchg.githubuser.domain.repository.IGithubUserRepository
import io.reactivex.Single

class GithubUserRepository(private val cloud: GithubCloud, private val local: GithubUserDao) :
    IGithubUserRepository {

    override fun users(): Single<List<GithubUser>> = cloud.users().map { it.mapList() }

    override fun user(login: String): Single<GithubUser> = cloud.user(login).map { it.map() }
}
