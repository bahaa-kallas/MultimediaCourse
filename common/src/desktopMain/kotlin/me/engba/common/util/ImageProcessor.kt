package me.engba.common.util

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asDesktopBitmap
import androidx.compose.ui.graphics.toArgb
import me.engba.common.extensions.toImageBitmap
import java.awt.Color
import java.awt.image.BufferedImage


actual fun applyInvert(image: ImageBitmap): ImageBitmap {
  val desktopBitmap = image.asDesktopBitmap()
  val copy = BufferedImage(desktopBitmap.width, desktopBitmap.height, BufferedImage.TYPE_INT_RGB)
  (0 until copy.width).forEach { i ->
    (0 until copy.height).forEach { j ->
      val pixel = Color(desktopBitmap.getColor(i, j))
      val invertedPixel = Color(255 - pixel.red, 255 - pixel.green, 255 - pixel.blue)
      copy.setRGB(i, j, invertedPixel.rgb)
    }
  }
  return copy.toImageBitmap()
}


