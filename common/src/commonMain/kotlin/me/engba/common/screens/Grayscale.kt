package me.engba.common.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Grayscale(
  setLoading: (Boolean) -> Unit,
) {
  val dropDownMenuOpen = remember { mutableStateOf(false) }
  val scope = rememberCoroutineScope()

  val toggleDropDownState = { dropDownMenuOpen.value = !dropDownMenuOpen.value }
  val onItemSelected = { index: Int ->
    toggleDropDownState()
  }
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(8.dp)
  ) {
    Card {
      Column(Modifier.padding(8.dp)) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          Text(fontWeight = FontWeight.W500, text = "Choose a grayscale algorithm to apply")

        }
      }
    }
  }
}
