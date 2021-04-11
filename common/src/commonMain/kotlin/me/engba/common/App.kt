package me.engba.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import kotlinx.coroutines.launch
import me.engba.common.app.AppScreens
import me.engba.common.components.appBar.AppBar
import me.engba.common.components.drawerMenu.DrawerMenu
import me.engba.common.screens.*
import me.engba.common.theme.AppTheme
import java.io.File

data class ImageViewerConfig(
    val onImagePickerOpen: () -> Unit,
    val onImageResetClick: () -> Unit,
    val onImageChange: (ImageBitmap) -> Unit,
    val selectedFile: ImageBitmap
)

@ExperimentalMultiplatform
@Composable
fun App(
    deviceTheme: AppTheme,
    imageViewerConfig: ImageViewerConfig
) {
    val appBarTitle = remember { mutableStateOf(AppScreens.COLOR_FILTER.readableName) }
    val currentScreen = remember { mutableStateOf(AppScreens.COLOR_FILTER) }
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val loading = remember { mutableStateOf(false) }
    val currentTheme = remember { mutableStateOf(deviceTheme) }
    val scope = rememberCoroutineScope()

    val setLoading = { value: Boolean ->
        loading.value = value
    }
    val navigateToScreen = { screen: AppScreens ->
        scope.launch { drawerState.close() }
        appBarTitle.value = screen.readableName
        currentScreen.value = screen
    }
    val toggleTheme = {
        when (currentTheme.value) {
            AppTheme.DARK -> currentTheme.value = AppTheme.LIGHT
            AppTheme.LIGHT -> currentTheme.value = AppTheme.DARK
        }
    }
    AppTheme(isLight = true) {
        ModalDrawer(
            drawerState = drawerState,
            drawerContent = { DrawerMenu(navigateToScreen) }) {
            Column {
                AppBar(
                    title = appBarTitle.value,
                    toggleTheme = toggleTheme,
                    openDrawer = {
                        when (drawerState.currentValue) {
                            DrawerValue.Closed -> drawerState.open()
                            DrawerValue.Open -> drawerState.close()
                        }
                    })
                if (loading.value) {
                    LinearProgressIndicator(modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colors.secondary)
                }
                when (currentScreen.value) {
                    AppScreens.COLOR_FILTER -> ColorFilterScreen(setLoading)
                    AppScreens.BRIGHTNESS -> Brightness(setLoading)
                    AppScreens.INVERT -> Invert(setLoading,imageViewerConfig)
                    AppScreens.GRAYSCALE -> Grayscale(setLoading)
                    AppScreens.CONTRAST -> Contrast(setLoading)
                    AppScreens.MEAN_FILTER -> MeanFilter(setLoading)
                }
            }
        }
    }
}
