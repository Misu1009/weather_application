package com.rogerferdinan.weather_app.ui

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rogerferdinan.weather_app.ui.screen.ForecastScreen
import com.rogerferdinan.weather_app.ui.screen.HistoricalScreen
import com.rogerferdinan.weather_app.viewmodel.WeatherViewModel

@Composable
fun WeatherApp(context: Context){
    var navController = rememberNavController()
    var viewModel: WeatherViewModel = viewModel()

    val uiState by viewModel.uiState.collectAsState()

    var currentDegree = uiState.current_weather.temperature
    var foreCastDegree = uiState.daily.temperature
    var windSpeed = uiState.current_weather.windspeed

    NavHost(
        navController = navController,
        startDestination = "ForecastScreen"
    ) {
        composable(route = "ForecastScreen"){
            ForecastScreen(
                currentDegree = currentDegree,
                foreCastDegree = foreCastDegree,
                windSpeed = viewModel.toKmPerHour(windSpeed),
                getWeatherIcon = viewModel::getWeatherIcon,
                foreCastClick = {
                    navController.navigate("ForecastScreen")
                }
            ){
                navController.navigate("HistoricalScreen")
            }
        }
        composable(route = "HistoricalScreen"){
            HistoricalScreen(
                foreCastClick = {
                    navController.navigate("ForecastScreen")
                }
            ) {
                navController.navigate("HistoricalScreen")
            }
        }
    }
}
