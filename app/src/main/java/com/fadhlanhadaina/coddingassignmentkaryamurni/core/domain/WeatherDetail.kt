package com.fadhlanhadaina.coddingassignmentkaryamurni.core.domain


data class WeatherDetail (
    val dt: Long,
    val pressure: String,
    val humidity: String,
    val temp: String,
    val weather: WeatherType,
)
