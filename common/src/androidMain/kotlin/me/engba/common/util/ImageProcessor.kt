package me.engba.common.util

import android.graphics.Bitmap
import androidx.compose.ui.graphics.*
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red

actual fun applyInvert(image: ImageBitmap): ImageBitmap {
  val androidBitmap = image.asAndroidBitmap()
  val copy = Bitmap.createBitmap(image.width, image.height, Bitmap.Config.ARGB_8888)
  (0 until copy.width).forEach { i ->
    (0 until copy.height).forEach { j ->
      val pixel = androidBitmap.getPixel(i, j)
      val newRGBPixel = Color(255 - pixel.red, 255 - pixel.green, 255 - pixel.blue)
      copy.setPixel(i, j, newRGBPixel.toArgb())
    }
  }
  return copy.asImageBitmap()
}


