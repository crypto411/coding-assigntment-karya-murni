package com.fadhlanhadaina.coddingassignmentkaryamurni.core.data.remote

import com.google.gson.annotations.SerializedName

data class DailyWeatherDetailResponse(
    @SerializedName("dt")
    val dt: Long,
    @SerializedName("pressure")
    val pressure: String,
    @SerializedName("humidity")
    val humidity: String,
    @SerializedName("temp")
    val temp: TempResponse,
    @SerializedName("weather")
    val weather: ArrayList<WeatherTypeResponse>,
)
