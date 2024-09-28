package com.legalad.hack_yeah_2024_cycle_v2.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics

@Composable
fun CommonSwitch(
    isChecked: Boolean,
    isCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Switch(
        modifier = Modifier.semantics { contentDescription = "Demo with icon" },
        checked = isChecked,
        onCheckedChange = isCheckedChange,
        thumbContent = {
            if (isChecked) {
                // Icon isn't focusable, no need for content description
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                )
            }
        }
    )
}