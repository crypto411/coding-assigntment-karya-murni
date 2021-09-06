package com.fadhlanhadaina.coddingassignmentkaryamurni.core.data.remote

import android.util.Log
import com.fadhlanhadaina.coddingassignmentkaryamurni.core.domain.Weather
import com.fadhlanhadaina.coddingassignmentkaryamurni.core.util.Mapper.mapToWeatherModel
import com.fadhlanhadaina.coddingassignmentkaryamurni.core.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val clientApi: OpenWeatherResource) {
    fun getWeatherDetail(params: HashMap<String, String>): Flow<Resource<Weather>> = flow {
        emit(Resource.Loading())
        try {
            val response = clientApi.getWeatherDetail(params)
            if(response.message == null) {
                emit(Resource.Success<Weather>(mapToWeatherModel(response)))
            }
            else {
                emit(Resource.Error<Weather>("Data tidak ditemukan"))
            }
        }
        catch (e: Exception) {
            Log.d("RDS@E", e.toString())
            emit(Resource.Error<Weather>(e.toString()))
        }
    }
}
