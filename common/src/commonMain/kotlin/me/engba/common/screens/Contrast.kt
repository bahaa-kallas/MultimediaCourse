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
import kotlinx.coroutines.launch

private val DEFAULT_CONTRAST = 0f

@Composable
fun Contrast(
    setLoading: (Boolean) -> Unit
) {
    val contrastLevel = remember { mutableStateOf(DEFAULT_CONTRAST) }
    fun setContrastLevel(value: Float) {
        contrastLevel.value = value
    }

    val scope = rememberCoroutineScope()


    val onContrastSliderChange = { value: Float ->
        setContrastLevel(value)
        setLoading(true)
        scope.launch {
            setLoading(false)
        }
        Unit
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text("Contrast Level")
        Spacer(Modifier.height(2.dp))
        Slider(
            valueRange = -100f..100f,
            value = contrastLevel.value,
            onValueChange = onContrastSliderChange
        )
    }
}
