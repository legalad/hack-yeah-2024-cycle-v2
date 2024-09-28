package com.legalad.hack_yeah_2024_cycle_v2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.legalad.hack_yeah_2024_cycle_v2.ui.theme.Hackyeah2024cyclev2Theme
import com.mapbox.maps.extension.compose.MapboxMap
import com.mapbox.maps.extension.compose.animation.viewport.rememberMapViewportState
import com.mapbox.maps.plugin.viewport.DEFAULT_FOLLOW_PUCK_VIEWPORT_STATE_ZOOM

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Hackyeah2024cyclev2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MapboxMap(
                        modifier = Modifier.fillMaxSize().padding(innerPadding),
                        mapViewportState = rememberMapViewportState()
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Hackyeah2024cyclev2Theme {
        Greeting("Android")
    }
}