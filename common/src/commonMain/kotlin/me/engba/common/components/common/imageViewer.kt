package me.engba.common.components.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Refresh
import androidx.compose.material.icons.sharp.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.dp
import me.engba.common.ImageViewerConfig
import java.io.File


@Composable
fun imageViewer(
    imageViewerConfig:ImageViewerConfig
) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            bitmap = imageViewerConfig.selectedFile,
            contentDescription = null,
            modifier = Modifier.width(640.dp)
                .heightIn(max = 320.dp)
                .padding(bottom = 16.dp)
        )
        Row {
            Button(
                onClick = imageViewerConfig.onImagePickerOpen,
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
            ) {
                Icon(imageVector = Icons.Sharp.Search, contentDescription = null)
                Spacer(Modifier.width(4.dp))
                Text("Select Image")
            }
            Spacer(Modifier.width(2.dp))
            Button(
                onClick = imageViewerConfig.onImageResetClick,
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
            ) {
                Icon(imageVector = Icons.Sharp.Refresh, contentDescription = null)
                Spacer(Modifier.width(4.dp))
                Text("Reset")
            }
        }
    }
}
