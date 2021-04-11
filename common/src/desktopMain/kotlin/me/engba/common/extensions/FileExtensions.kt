package me.engba.common.extensions

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

fun File.toBufferedImage(): BufferedImage {
    return ImageIO.read(this)
}
