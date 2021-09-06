package com.fadhlanhadaina.coddingassignmentkaryamurni.core.domain


data class Weather(
    val currentWeather: WeatherDetail?,
    val forecastWeather: ArrayList<WeatherDetail>
)
