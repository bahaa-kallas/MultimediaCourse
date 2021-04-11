package me.engba.common.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toPixelMap
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import me.engba.common.ImageViewerConfig
import me.engba.common.components.common.imageViewer
import me.engba.common.model.BitmapWithPixels
import me.engba.common.util.applyInvert

@ExperimentalMultiplatform
@Composable
fun Invert(
    setLoading: (Boolean) -> Unit,
    imageViewerConfig: ImageViewerConfig
) {
    val invertCheckbox = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    fun setInvertCheckbox(newValue: Boolean) {
        invertCheckbox.value = newValue
    }

    val onInvertCheckboxChange = { checked: Boolean ->
        setInvertCheckbox(checked)

        scope.launch {
            setLoading(true)
            if (checked) {
                imageViewerConfig.onImageChange(applyInvert(imageViewerConfig.selectedFile))
            }
            setLoading(false)
        }
        Unit
    }

    Column {
        Card(elevation = 8.dp, modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Switch(checked = invertCheckbox.value, onCheckedChange = onInvertCheckboxChange)
                    Spacer(Modifier.width(4.dp))
                    Text("Apply Inversion")
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        imageViewer(imageViewerConfig)
    }
}
