package com.rogerferdinan.weather_app.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rogerferdinan.weather_app.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoricalScreen(
    foreCastClick: ()-> Unit,
    historicalClick: ()-> Unit
){
    Scaffold(
        topBar = { TopBar() },
        bottomBar = {
            BottomBar(
                foreCastClick = foreCastClick,
                historicalClick = historicalClick
            )
        }
    ){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(it)
        ) {

        }
    }
}

@Composable
private fun TopBar(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_cloud_queue_24),
            contentDescription = null,
            modifier = Modifier.size(100.dp),
            tint = Color(0xff16C6F5)
        )
    }
}
@Composable
private fun BottomBar(
    foreCastClick: ()-> Unit,
    historicalClick: ()-> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_cloud_circle_24),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .weight(1f)
                .clickable { foreCastClick() },
            tint = Color(0xff22F8FC)

        )
        Icon(
            painter = painterResource(id = R.drawable.baseline_cloud_done_24),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .weight(1f)
                .clickable { historicalClick() }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun previeww(){
//    WeatherAndDegree()
    HistoricalScreen({}, {})
}