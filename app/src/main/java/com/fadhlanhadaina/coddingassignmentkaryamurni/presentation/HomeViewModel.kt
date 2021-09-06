package com.fadhlanhadaina.coddingassignmentkaryamurni.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.switchMap
import com.fadhlanhadaina.coddingassignmentkaryamurni.core.data.WeatherRepository
import com.fadhlanhadaina.coddingassignmentkaryamurni.core.domain.GeoLocation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: WeatherRepository): ViewModel() {

    val _geo = MutableLiveData<GeoLocation>()
    val weather = _geo.switchMap {
        repository.getWeather(it.lat, it.lon).asLiveData()
    }

    init {
        _geo.value = GeoLocation("52.2298", "21.0118")
    }
}