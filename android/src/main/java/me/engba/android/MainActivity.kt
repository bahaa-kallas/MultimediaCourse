package me.engba.android

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import me.engba.common.App
import me.engba.common.ImageViewerConfig
import me.engba.common.theme.AppTheme
import java.nio.Buffer

@ExperimentalMultiplatform
class MainActivity : AppCompatActivity() {
    private val selectedImagePixels = mutableStateOf<ImageBitmap?>(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(
                deviceTheme = AppTheme.LIGHT,
                ImageViewerConfig(
                    onImagePickerOpen = { selectImageLauncher.launch("image/*") },
                    onImageResetClick = { selectedImagePixels.value = null },
                    onImageChange = { selectedImagePixels.value = it },
                    selectedFile = selectedImagePixels.value ?: defaultImage
                )
            )
        }
    }

    private val selectImageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        selectedImagePixels.value = BitmapFactory.decodeStream(contentResolver.openInputStream(uri))
            .asImageBitmap()
    }

    private val defaultImage by lazy {
        BitmapFactory.decodeResource(resources, R.drawable.sample).asImageBitmap()
    }
}
