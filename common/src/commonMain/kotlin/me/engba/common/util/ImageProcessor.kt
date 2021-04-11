package me.engba.common.util

import androidx.compose.ui.graphics.ImageBitmap
import me.engba.common.model.BitmapWithPixels
import java.io.File

@ExperimentalMultiplatform
expect fun applyInvert(image: ImageBitmap): ImageBitmap
