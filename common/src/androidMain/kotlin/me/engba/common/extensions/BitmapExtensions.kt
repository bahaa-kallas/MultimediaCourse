package me.engba.common.extensions

import android.graphics.Bitmap
import androidx.compose.ui.graphics.Color

fun Bitmap.getRGBColor(x: Int, y: Int) = Color(this.getPixel(x, y))
