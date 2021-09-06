package com.fadhlanhadaina.coddingassignmentkaryamurni.core.util

import com.fadhlanhadaina.coddingassignmentkaryamurni.BuildConfig

object Query {
    fun getWeatherQueryParams(lat: String, lon: String): HashMap<String, String> {
        val map = HashMap<String, String>()
        map["lat"] = lat
        map["lon"] = lon
        map["exclude"] = "minutely,alerts,hourly"
        map["units"] = "metric"
        return map
    }
}