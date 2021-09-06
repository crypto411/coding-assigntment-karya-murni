package com.fadhlanhadaina.coddingassignmentkaryamurni.core.data

import com.fadhlanhadaina.coddingassignmentkaryamurni.core.data.remote.RemoteDataSource
import com.fadhlanhadaina.coddingassignmentkaryamurni.core.domain.Weather
import com.fadhlanhadaina.coddingassignmentkaryamurni.core.util.Query.getWeatherQueryParams
import com.fadhlanhadaina.coddingassignmentkaryamurni.core.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepository @Inject constructor(private val remote: RemoteDataSource) {

    fun getWeather(lat: String, lon: String): Flow<Resource<Weather>> =
        remote.getWeatherDetail(getWeatherQueryParams(lat, lon))
}
