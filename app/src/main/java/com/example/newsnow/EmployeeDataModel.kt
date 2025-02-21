package com.example.newsnow

import com.google.gson.annotations.SerializedName

data class EmployeeDataModel(
    val login: String,
    val id: Long,
    val node_id: String,
    @SerializedName("avatar_url")
    val avatar: String,
    val gravatar_id: String,
    val url: String,
    val htmlUrl: String,
    val followersUrl: String,
    val followingUrl: String,
    val gistsUrl: String,
    val starredUrl: String,
    val subscriptionsUrl: String,
    val organizationsUrl: String,
    val reposUrl: String,
    val eventsUrl: String,
    val receivedEventsUrl: String,
    val type: String,
    val userViewType: String,
    val siteAdmin: Boolean,
)
