package me.engba.common.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun MeanFilter(
  setLoading: (Boolean) -> Unit
) {
  val meanFilterCheckbox = remember { mutableStateOf(false) }
  val scope = rememberCoroutineScope()

  fun setInvertCheckbox(newValue: Boolean) {
    meanFilterCheckbox.value = newValue
  }

  val onMeanFilterCheckboxChange = { checked: Boolean ->
    setInvertCheckbox(checked)
    setLoading(true)
    scope.launch(Dispatchers.Unconfined) {
      if (checked) {
      } else {
      }
      setLoading(false)
    }
    Unit
  }

  Column {
    Card(elevation = 8.dp, modifier = Modifier.fillMaxWidth()) {
      Column(modifier = Modifier.padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Switch(checked = meanFilterCheckbox.value, onCheckedChange = onMeanFilterCheckboxChange)
          Spacer(Modifier.width(4.dp))
          Text("Apply Inversion")
        }
      }
    }
    Spacer(modifier = Modifier.height(16.dp))
  }
}
