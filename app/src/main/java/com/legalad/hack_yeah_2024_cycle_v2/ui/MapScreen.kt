package com.legalad.hack_yeah_2024_cycle_v2.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.legalad.hack_yeah_2024_cycle_v2.ui.components.CommonSwitch
import com.legalad.hack_yeah_2024_cycle_v2.ui.components.NavSearchBar
import com.mapbox.maps.extension.compose.MapEffect
import com.mapbox.maps.extension.compose.MapboxMap
import com.mapbox.maps.extension.compose.animation.viewport.rememberMapViewportState
import com.mapbox.maps.extension.compose.style.MapStyle
import com.mapbox.maps.extension.style.layers.getLayer
import com.mapbox.maps.extension.style.layers.properties.generated.Visibility

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapScreen(
    modifier: Modifier = Modifier,
    viewModel: MapScreenViewModel = MapScreenViewModel(),
) {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()
    val state = viewModel.viewState.collectAsState()
    BottomSheetScaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        sheetContent = {
            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text(
                        text = "Przeciągnij, żeby zamknąć",
                        style = MaterialTheme.typography.labelLarge
                    )
                }
                state.value.layers.forEachIndexed { index, layer ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(layer.iconId),
                            contentDescription = null,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                        Text(
                            text = layer.title,
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 12.dp)
                        )
                        CommonSwitch(
                            isChecked = layer.isVisible,
                            isCheckedChange = { isChecked ->
                                viewModel.onToggleClicked(
                                    id = index,
                                    value = isChecked
                                )
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            MapboxMap(
                modifier = Modifier.fillMaxSize(),
                style = {
                    MapStyle(
                        style = "mapbox://styles/peivul/cm1m0jkdm00im01ph66thdcdf",
                    )
                },
                mapViewportState = rememberMapViewportState()
            ) {
                MapEffect(state.value.layers) { mapView ->
                    state.value.layers.forEach { layer ->
                        val mapLayer = mapView.mapboxMap.getLayer(layer.name)
                        val visibility =
                            if (layer.isVisible) Visibility.VISIBLE else Visibility.NONE
                        mapLayer?.visibility(visibility)
                    }
                }
            }
            NavSearchBar { }
        }
    }
}