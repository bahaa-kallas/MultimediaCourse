package me.engba.common.extensions

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import org.jetbrains.skija.Image
import java.awt.Color
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import javax.imageio.ImageIO

fun BufferedImage.getRGBColor(x: Int, y: Int): Color = Color(this.getRGB(x, y))

fun BufferedImage.toImageBitmap(): ImageBitmap {
    val bos = ByteArrayOutputStream()
    ImageIO.write(this, "jpg", bos)
    return Image.makeFromEncoded(bos.toByteArray())
        .asImageBitmap()
}
