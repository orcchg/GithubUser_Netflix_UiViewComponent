package com.orcchg.githubuser.data.repository

import com.orcchg.githubuser.data.local.GithubUserDao
import com.orcchg.githubuser.data.remote.GithubCloud
import com.orcchg.githubuser.domain.DomainUtil
import com.orcchg.githubuser.domain.model.GithubUser
import com.orcchg.githubuser.domain.model.mapList
import com.orcchg.githubuser.domain.repository.IGithubUserRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

class GithubUserRepository(private val cloud: GithubCloud, private val local: GithubUserDao) :
    IGithubUserRepository {

    override fun users(): Observable<List<GithubUser>> {
        val db = local.users().map { it.mapList() }.toObservable()
        val net = cloud.users().map { it.mapList() }.toObservable()
        return Observable.concatArrayEager(db, net)
            .materialize()
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                it.error?.let {  }
                it
            }
            .filter { !it.isOnError }
            .dematerialize<List<GithubUser>>()
            .debounce(DomainUtil.DEBOUNCE_NET, TimeUnit.SECONDS)
    }

    override fun user(login: String): Observable<GithubUser> = cloud.user(login).map { it.map() }
}
