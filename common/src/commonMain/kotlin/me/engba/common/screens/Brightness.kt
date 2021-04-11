package me.engba.common.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private val DEFAULT_BRIGHTNESS = 0f

@Composable
fun Brightness(
    setLoading: (Boolean) -> Unit
) {
    val brightnessLevel = remember { mutableStateOf(DEFAULT_BRIGHTNESS) }
    val scope = rememberCoroutineScope()


    fun setBrightnessLevel(value: Float) {
        brightnessLevel.value = value
    }

    val onBrightnessSliderChange = { value: Float ->
        scope.launch {
            withContext(Dispatchers.Main) { setBrightnessLevel(value) }
        }
        Unit
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text("Brightness Level")
        Spacer(Modifier.height(2.dp))
        Slider(
            valueRange = -255f..255f,
            value = brightnessLevel.value,
            onValueChange = onBrightnessSliderChange
        )
    }
}
