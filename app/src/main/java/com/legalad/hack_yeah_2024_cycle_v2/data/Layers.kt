package com.legalad.hack_yeah_2024_cycle_v2.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.legalad.hack_yeah_2024_cycle_v2.R

private const val PARKING_LAYER_KEY = "parkingi"
private const val CYCLE_FRIENDLY_LAYER_KEY = "miejsce-przyjazne-rowerzystom"
private const val SHELTERS_LAYER_KEY = "wiaty-promy-wodainne"
private const val IMPEDIMENTS_LAYER_KEY = "objazdy-utrudnienia"
private const val RECOMMENDED_ROUTES_LAYER_KEY = "rekomendowane-szlaki-rowerowe"
private const val ROAD_SURFACE_LAYER_KEY = "stan-prac-rodzaj-nawierzchni-droga-publiczna"
private const val TRAFFIC_LAYER_KEY = "traffic"

private const val s = "Rodzaj nawierzchni"

val layersData = listOf(
    Layer(
        name = PARKING_LAYER_KEY,
        iconId = R.drawable.rounded_local_parking_24,
        titleId = R.string.parking_lots
    ),
    Layer(
        name = CYCLE_FRIENDLY_LAYER_KEY,
        iconId = R.drawable.round_pedal_bike_24,
        titleId = R.string.cycle_friendly_place
    ),
    Layer(
        name = SHELTERS_LAYER_KEY,
        iconId = R.drawable.round_home_24,
        titleId = R.string.shelters
    ),
    Layer(
        name = IMPEDIMENTS_LAYER_KEY,
        iconId = R.drawable.rounded_warning_24,
        titleId = R.string.impedements
    ),
    Layer(
        name = RECOMMENDED_ROUTES_LAYER_KEY,
        iconId = R.drawable.round_recommend_24,
        titleId = R.string.recommended_routes
    ),
    Layer(
        name = ROAD_SURFACE_LAYER_KEY,
        iconId = R.drawable.rounded_route_24,
        titleId = R.string.road_surface
    ),
    Layer(
        name = TRAFFIC_LAYER_KEY,
        iconId = R.drawable.rounded_traffic_jam_24,
        titleId = R.string.traffic
    )
)

data class Layer(
    val name: String,
    val isVisible: Boolean = true,
    @DrawableRes val iconId: Int,
    @StringRes val titleId: Int
)
