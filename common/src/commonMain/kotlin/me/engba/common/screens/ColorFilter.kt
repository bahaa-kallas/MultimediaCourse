package me.engba.common.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

val classLoader = Thread.currentThread().contextClassLoader!!

@Composable
fun ColorFilterScreen(
  setLoading: (Boolean) -> Unit
) {
  val redFilterCheckbox = remember { mutableStateOf(false) }
  val greenFilterCheckbox = remember { mutableStateOf(false) }
  val blueFilterCheckbox = remember { mutableStateOf(false) }

  val onRedCheckBoxChange = { checked: Boolean ->
    redFilterCheckbox.value = checked
    Unit
  }
  val onGreenCheckBoxChange = { checked: Boolean ->
    greenFilterCheckbox.value = checked
    Unit
  }
  val onBlueCheckBoxChange = { checked: Boolean ->
    blueFilterCheckbox.value = checked
    Unit
  }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(8.dp)
  ) {
    Card(elevation = 8.dp, modifier = Modifier.fillMaxWidth()) {
      Column(modifier = Modifier.padding(16.dp)) {
        Text(fontWeight = FontWeight.W500, text = "Select one of the color filters to apply on the shown image")
        Spacer(modifier = Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
          Checkbox(checked = redFilterCheckbox.value, onCheckedChange = onRedCheckBoxChange)
          Text("Red Filter")
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
          Checkbox(checked = greenFilterCheckbox.value, onCheckedChange = onGreenCheckBoxChange)
          Text("Green Filter")
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
          Checkbox(checked = blueFilterCheckbox.value, onCheckedChange = onBlueCheckBoxChange)
          Text("Blue Filter")
        }
      }
    }
    Spacer(Modifier.height(16.dp))
  }
}
