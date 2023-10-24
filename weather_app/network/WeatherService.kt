package com.rogerferdinan.weather_app.network

import com.rogerferdinan.weather_app.data.WeatherUiState
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("v1/forecast")
    suspend fun getForecast(
        @Query("latitude") latitude: Float,
        @Query("longitude") longitude: Float,
        @Query("current_weather") current_weather: Boolean = true,
        @Query("forecast_days") forecast_days: Int = 0,
        @Query("timezone") timezone: String = "auto",
        @Query("daily") daily: String = "temperature_2m_max"
    ): Response<WeatherUiState>
}