package com.orcchg.githubuser.data.local

import androidx.room.Dao
import androidx.room.Query
import com.orcchg.githubuser.domain.model.GithubUser
import io.reactivex.Single

@Dao
interface GithubUserDao {

    @Query("SELECT * FROM ${GithubUser.TABLE_NAME}")
    fun users(): Single<List<GithubUser>>

    @Query("SELECT * FROM ${GithubUser.TABLE_NAME} WHERE :${GithubUser.COLUMN_LOGIN} = :login")
    fun user(login: String): Single<GithubUser>
}
