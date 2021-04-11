package me.engba.common.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val indigo = Color(0xFF3F51B5)
private val primaryText = Color(0xFFFFFFFF)
private val indigoVariant = Color(0xFF002984)

private val pink = Color(0xFFFF4081)
private val secondaryText = Color(0xFF000000)
private val pinkVariant = Color(0xFFC60055)

private val background = Color(0xFFFAFAFA)
private val onBackground = Color(0xFF212121)

private val surface = Color(0xFFF6F6F6)
private val onSurface = Color(0xFF202020)

private val error = Color(0xFFFF0000)
private val onError = Color(0xFFFFFFFF)

val darkColors = darkColors()

enum class AppTheme { DARK, LIGHT }

@Composable
fun AppTheme(isLight: Boolean, content: @Composable () -> Unit) {
    MaterialTheme(
        colors = Colors(
            primary = indigo,
            onPrimary = primaryText,
            primaryVariant = indigoVariant,
            secondary = pink,
            onSecondary = secondaryText,
            secondaryVariant = pinkVariant,
            background = background,
            onBackground = onBackground,
            surface = surface,
            onSurface = onSurface,
            error = error,
            onError = onError,
            isLight = isLight
        )
    ) {
        content()
    }
}
