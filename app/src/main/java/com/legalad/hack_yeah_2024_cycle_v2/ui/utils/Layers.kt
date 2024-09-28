package com.legalad.hack_yeah_2024_cycle_v2.ui.utils

import com.legalad.hack_yeah_2024_cycle_v2.R

val layersData = listOf(
    Layer(
        name = "parkingi",
        iconId = R.drawable.rounded_local_parking_24,
        title = "Parkingi"
    ),
    Layer(
        name = "miejsce-przyjazne-rowerzystom",
        iconId = R.drawable.round_pedal_bike_24,
        title = "Miejsce przyjazne rowerzystom"
    ),
    Layer(
        name = "wiaty-promy-wodainne",
        iconId = R.drawable.round_home_24,
        title = "Wiaty"
    ),
    Layer(
        name = "objazdy-utrudnienia",
        iconId = R.drawable.rounded_warning_24,
        title = "Objazdy i utrudnienia"
    ),
    Layer(
        name = "rekomendowane-szlaki-rowerowe",
        iconId = R.drawable.round_recommend_24,
        title = "Rekomendowane trasy"
    ),
    Layer(
        name = "stan-prac-rodzaj-nawierzchni-droga-publiczna",
        iconId = R.drawable.rounded_route_24,
        title = "Rodzaj nawierzchni"
    ),
    Layer(
        name = "traffic",
        iconId = R.drawable.rounded_traffic_jam_24,
        title = "Natężenie ruchu"
    )
)

data class Layer(
    val name: String,
    val isVisible: Boolean = true,
    val iconId: Int,
    val title: String
)