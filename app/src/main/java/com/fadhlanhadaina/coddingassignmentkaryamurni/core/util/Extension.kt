package com.fadhlanhadaina.coddingassignmentkaryamurni.core.util

import android.annotation.SuppressLint
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.fadhlanhadaina.coddingassignmentkaryamurni.R

object Extension {
    fun ImageView.loadWeatherIcon(icon: String, width: Int = 32, height: Int = 32) {
        Glide.with(this.context)
            .load("https://openweathermap.org/img/wn/$icon.png")
            .override(width, height)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.drawable.clouds_sun)
            .error(R.drawable.ic_baseline_error_24)
            .into(this)
    }
}