package com.legalad.hack_yeah_2024_cycle_v2

import android.app.Application
import com.mapbox.navigation.base.options.NavigationOptions
import com.mapbox.navigation.core.lifecycle.MapboxNavigationApp

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (!MapboxNavigationApp.isSetup()) {
            MapboxNavigationApp.setup {
                NavigationOptions.Builder(this)
                    .build()
            }
        }
    }
}