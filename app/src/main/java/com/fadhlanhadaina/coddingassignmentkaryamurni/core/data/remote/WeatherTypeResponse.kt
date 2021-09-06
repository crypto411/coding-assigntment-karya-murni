package com.fadhlanhadaina.coddingassignmentkaryamurni.core.data.remote

import com.google.gson.annotations.SerializedName

data class WeatherTypeResponse (
    @SerializedName("id")
    val id: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("icon")
    val icon: String
)
