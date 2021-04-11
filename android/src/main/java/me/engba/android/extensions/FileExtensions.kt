package me.engba.android.extensions

import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.asImageBitmap
import java.io.File

fun File.toImageBitmap() = BitmapFactory.decodeFile(this.path).asImageBitmap()
