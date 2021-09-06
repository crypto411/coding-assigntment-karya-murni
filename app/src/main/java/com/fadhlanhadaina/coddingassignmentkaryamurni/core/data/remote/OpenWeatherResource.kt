package com.fadhlanhadaina.coddingassignmentkaryamurni.core.data.remote

import com.fadhlanhadaina.coddingassignmentkaryamurni.BuildConfig
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface OpenWeatherResource {
    @GET("onecall?appid=$API_KEY")
    suspend fun getWeatherDetail(@QueryMap query: HashMap<String, String>): WeatherResponse

    companion object {
        const val API_KEY = BuildConfig.API_KEY
    }
}
