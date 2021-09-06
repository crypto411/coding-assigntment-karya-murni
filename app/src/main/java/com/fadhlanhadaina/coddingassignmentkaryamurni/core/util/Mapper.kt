package com.fadhlanhadaina.coddingassignmentkaryamurni.core.util

import android.text.format.DateFormat
import android.util.Log
import com.fadhlanhadaina.coddingassignmentkaryamurni.core.data.remote.WeatherResponse
import com.fadhlanhadaina.coddingassignmentkaryamurni.core.domain.Weather
import com.fadhlanhadaina.coddingassignmentkaryamurni.core.domain.WeatherDetail
import com.fadhlanhadaina.coddingassignmentkaryamurni.core.domain.WeatherType
import java.text.SimpleDateFormat
import java.util.*

object Mapper {
    fun mapToWeatherModel(weatherResponse: WeatherResponse): Weather {
        val _currentWeather = weatherResponse.currentWeather
        val _forecastWeather = weatherResponse.forecastWeather
        val currentWeather = WeatherDetail(
            _currentWeather.dt,
            _currentWeather.pressure,
            _currentWeather.humidity,
            _currentWeather.temp,
            WeatherType(
                _currentWeather.weather[0].id,
                _currentWeather.weather[0].description,
                _currentWeather.weather[0].icon
            )
        )
        val forecastWeather = arrayListOf<WeatherDetail>()
        for (weatherDetailResponse in _forecastWeather) {
            val weatherDetail = WeatherDetail(
                weatherDetailResponse.dt,
                weatherDetailResponse.pressure,
                weatherDetailResponse.humidity,
                weatherDetailResponse.temp.value,
                WeatherType(
                    weatherDetailResponse.weather[0].id,
                    weatherDetailResponse.weather[0].description,
                    weatherDetailResponse.weather[0].icon,
                )
            )
            forecastWeather.add(weatherDetail)
        }
        return Weather(currentWeather, forecastWeather)
    }
    fun mapLongToSmallDay(dt: Long): String =
        SimpleDateFormat("EEE").format(Date(dt * 1000))

    fun mapLongToDayDate(dt: Long): String =
        SimpleDateFormat("EEEE, MMMM dd").format(Date(dt * 1000))
}