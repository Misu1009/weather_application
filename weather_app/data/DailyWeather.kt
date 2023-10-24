package com.rogerferdinan.weather_app.data

import com.google.gson.annotations.SerializedName

data class DailyWeather(
    val time: List<String>,
    @SerializedName("temperature_2m_max")
    val temperature: List<Float>
)