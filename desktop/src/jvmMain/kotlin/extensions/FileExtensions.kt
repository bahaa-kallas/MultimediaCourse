package extensions

import androidx.compose.ui.graphics.asImageBitmap
import org.jetbrains.skija.Image.makeFromEncoded
import java.io.File

fun File.toImageBitmap() = makeFromEncoded(this.readBytes()).asImageBitmap()
