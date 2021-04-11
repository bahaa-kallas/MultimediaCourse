package me.engba.common.components.drawerMenu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.engba.common.app.AppScreens

@Composable
fun DrawerMenu(navigateToScreen: (AppScreens) -> Unit) {
    Column {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { navigateToScreen(AppScreens.COLOR_FILTER) }
        ) {
            Text(modifier = Modifier.padding(16.dp), text = AppScreens.COLOR_FILTER.readableName)
        }
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { navigateToScreen(AppScreens.GRAYSCALE) }
        ) {
            Text(modifier = Modifier.padding(16.dp), text = AppScreens.GRAYSCALE.readableName)
        }
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { navigateToScreen(AppScreens.INVERT) }
        ) {
            Text(modifier = Modifier.padding(16.dp), text = AppScreens.INVERT.readableName)
        }
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { navigateToScreen(AppScreens.BRIGHTNESS) }
        ) {
            Text(modifier = Modifier.padding(16.dp), text = AppScreens.BRIGHTNESS.readableName)
        }
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { navigateToScreen(AppScreens.CONTRAST) }
        ) {
            Text(modifier = Modifier.padding(16.dp), text = AppScreens.CONTRAST.readableName)
        }
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { navigateToScreen(AppScreens.MEAN_FILTER) }
        ) {
            Text(modifier = Modifier.padding(16.dp), text = AppScreens.MEAN_FILTER.readableName)
        }
    }
}
