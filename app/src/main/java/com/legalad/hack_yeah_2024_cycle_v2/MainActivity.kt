package com.legalad.hack_yeah_2024_cycle_v2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.legalad.hack_yeah_2024_cycle_v2.ui.MapScreen
import com.legalad.hack_yeah_2024_cycle_v2.ui.theme.Hackyeah2024cyclev2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Hackyeah2024cyclev2Theme {
                MapScreen()
            }
        }
    }
}