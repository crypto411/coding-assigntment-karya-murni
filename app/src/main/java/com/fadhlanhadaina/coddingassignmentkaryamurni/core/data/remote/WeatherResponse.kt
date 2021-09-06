package com.fadhlanhadaina.coddingassignmentkaryamurni.core.data.remote

import com.google.gson.annotations.SerializedName

data class WeatherResponse (
    @SerializedName("message")
    val message: String?,
    @SerializedName("current")
    val currentWeather: WeatherDetailResponse,
    @SerializedName("daily")
    val forecastWeather: ArrayList<DailyWeatherDetailResponse>
)
