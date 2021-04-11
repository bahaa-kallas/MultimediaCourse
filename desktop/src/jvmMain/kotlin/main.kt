import androidx.compose.desktop.Window
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.unit.IntSize
import extensions.toImageBitmap
import me.engba.common.App
import me.engba.common.ImageViewerConfig
import me.engba.common.theme.AppTheme
import java.awt.FileDialog
import java.awt.Frame


@ExperimentalMultiplatform
fun main() = Window(size = IntSize(800, 640)) {
  val selectedImage = remember { mutableStateOf<ImageBitmap?>(null) }
  val defaultImage by lazy { imageFromResource("sample.png") }
  val dialog = FileDialog(null as Frame?, "Select File to Open")

  App(
      deviceTheme = AppTheme.DARK,
      imageViewerConfig = ImageViewerConfig(
          onImageChange = { selectedImage.value = it },
          onImagePickerOpen = {
            dialog.mode = FileDialog.LOAD
            dialog.isVisible = true
            dialog.isMultipleMode = false
            if (dialog.files.isNotEmpty()){
              selectedImage.value = dialog.files[0].toImageBitmap()
            }
          },
          onImageResetClick = { selectedImage.value = defaultImage },
          selectedFile = selectedImage.value ?: defaultImage
      )
  )
}
