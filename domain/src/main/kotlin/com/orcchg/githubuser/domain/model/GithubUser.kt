package com.orcchg.githubuser.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.orcchg.githubuser.domain.model.GithubUser.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class GithubUser(
    @PrimaryKey @ColumnInfo(name = COLUMN_ID) val id: Int,
    @ColumnInfo(name = COLUMN_LOGIN) val login: String,
    @ColumnInfo(name = COLUMN_NAME) val name: String? = null,
    @ColumnInfo(name = COLUMN_BIO) val bio: String? = null,
    @SerializedName(COLUMN_AVATAR_URL) @ColumnInfo(name = COLUMN_AVATAR_URL) val avatarUrl: String? = null) {

    companion object {
        const val COLUMN_ID = "id"
        const val COLUMN_AVATAR_URL = "avatar_url"
        const val COLUMN_BIO = "bio"
        const val COLUMN_LOGIN = "login"
        const val COLUMN_NAME = "name"

        const val TABLE_NAME = "GithubUsers"
    }
}
