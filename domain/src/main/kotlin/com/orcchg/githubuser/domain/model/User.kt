package com.orcchg.githubuser.domain.model

import com.google.gson.annotations.SerializedName

data class User(val id: Int, val login: String, val name: String? = null, val bio: String? = null,
                @SerializedName("avatar_url") val avatarUrl: String? = null)
