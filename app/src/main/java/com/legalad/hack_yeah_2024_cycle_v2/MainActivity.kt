package com.legalad.hack_yeah_2024_cycle_v2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.legalad.hack_yeah_2024_cycle_v2.ui.MapScreen
import com.legalad.hack_yeah_2024_cycle_v2.ui.theme.Hackyeah2024cyclev2Theme
import com.mapbox.navigation.base.options.NavigationOptions
import com.mapbox.navigation.core.lifecycle.MapboxNavigationApp

class MainActivity : ComponentActivity() {
    init {
        lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onResume(owner: LifecycleOwner) {
                MapboxNavigationApp.attach(owner)
            }

            override fun onPause(owner: LifecycleOwner) {
                MapboxNavigationApp.detach(owner)
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!MapboxNavigationApp.isSetup()) {
            MapboxNavigationApp.setup {
                NavigationOptions.Builder(this).build()
            }
        }
        enableEdgeToEdge()
        setContent {
            Hackyeah2024cyclev2Theme {
                MapScreen()
            }
        }
    }
}