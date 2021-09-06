package com.fadhlanhadaina.coddingassignmentkaryamurni.core.data.remote

import com.google.gson.annotations.SerializedName

data class TempResponse(
    @SerializedName("day")
    val value: String,
)
