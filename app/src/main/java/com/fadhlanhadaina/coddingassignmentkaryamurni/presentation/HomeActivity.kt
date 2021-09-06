package com.fadhlanhadaina.coddingassignmentkaryamurni.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.fadhlanhadaina.coddingassignmentkaryamurni.R
import com.fadhlanhadaina.coddingassignmentkaryamurni.core.domain.Weather
import com.fadhlanhadaina.coddingassignmentkaryamurni.core.util.Extension.loadWeatherIcon
import com.fadhlanhadaina.coddingassignmentkaryamurni.core.util.Mapper.mapLongToDayDate
import com.fadhlanhadaina.coddingassignmentkaryamurni.core.util.Mapper.mapLongToSmallDay
import com.fadhlanhadaina.coddingassignmentkaryamurni.core.util.Resource
import com.fadhlanhadaina.coddingassignmentkaryamurni.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.roundToInt

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private val bind: ActivityHomeBinding by lazy { ActivityHomeBinding.inflate(layoutInflater)}
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bind.root)

        initView()
    }

    private fun initView() {
        supportActionBar?.hide()

        viewModel.weather.observe(this) {
            when(it) {
                is Resource.Loading -> {
                    bind.progress.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    it.data?.let { it1 -> updateView(it1) }
                }
                else -> {
                    bind.progress.visibility = View.GONE
                    it.message?.let { it1 -> Log.e("initView", it1) }
                }
            }
        }
    }

    private fun updateView(data: Weather) {
        bind.apply {
            progress.visibility = View.GONE
            date.text = data.currentWeather?.dt?.let { mapLongToDayDate(it) }
            pressureValue.text = getString(R.string.pressure_value, data.currentWeather?.pressure)
            humidityValue.text = getString(R.string.humidity_value, data.currentWeather?.humidity)
            data.currentWeather?.weather?.icon?.let { weatherIcon.loadWeatherIcon(it, 128, 128) }
            temperatureValue.text = getString(R.string.temp_value, data.currentWeather?.temp?.toFloat()?.roundToInt())
            weatherTitle.text = data.currentWeather?.weather?.description

            fIcon1.loadWeatherIcon(data.forecastWeather[0].weather.icon)
            fIcon2.loadWeatherIcon(data.forecastWeather[1].weather.icon)
            fIcon3.loadWeatherIcon(data.forecastWeather[2].weather.icon)
            fIcon4.loadWeatherIcon(data.forecastWeather[3].weather.icon)
            fIcon5.loadWeatherIcon(data.forecastWeather[4].weather.icon)
            fIcon6.loadWeatherIcon(data.forecastWeather[5].weather.icon)
            fIcon7.loadWeatherIcon(data.forecastWeather[6].weather.icon)
            fDay1.text = mapLongToSmallDay(data.forecastWeather[0].dt)
            fDay2.text = mapLongToSmallDay(data.forecastWeather[1].dt)
            fDay3.text = mapLongToSmallDay(data.forecastWeather[2].dt)
            fDay4.text = mapLongToSmallDay(data.forecastWeather[3].dt)
            fDay5.text = mapLongToSmallDay(data.forecastWeather[4].dt)
            fDay6.text = mapLongToSmallDay(data.forecastWeather[5].dt)
            fDay7.text = mapLongToSmallDay(data.forecastWeather[6].dt)
            fTemperature1.text = getString(R.string.temp_value, data.forecastWeather[0].temp.toFloat().roundToInt())
            fTemperature2.text = getString(R.string.temp_value, data.forecastWeather[1].temp.toFloat().roundToInt())
            fTemperature3.text = getString(R.string.temp_value, data.forecastWeather[2].temp.toFloat().roundToInt())
            fTemperature4.text = getString(R.string.temp_value, data.forecastWeather[3].temp.toFloat().roundToInt())
            fTemperature5.text = getString(R.string.temp_value, data.forecastWeather[4].temp.toFloat().roundToInt())
            fTemperature6.text = getString(R.string.temp_value, data.forecastWeather[5].temp.toFloat().roundToInt())
            fTemperature7.text = getString(R.string.temp_value, data.forecastWeather[6].temp.toFloat().roundToInt())
        }
    }
}