package com.fs.composeplayground.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


enum class Screen {
    AddName, People, Type
}

@Composable
@Preview(showBackground = true)
fun Menu(onMenuItemClick: (screen: Screen) -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
            .background(Color.LightGray)
    ) {
        val textModifier = Modifier
            .fillMaxHeight()
            .weight(1f)
            .wrapContentSize()
        Text(
            text = "Add Name",
            modifier = textModifier.clickable { onMenuItemClick(Screen.AddName) },
            textAlign = TextAlign.Center
        )
        Spacer(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
                .background(Color.DarkGray)
        )
        Text(
            text = "People",
            modifier = textModifier.clickable { onMenuItemClick(Screen.People) },
            textAlign = TextAlign.Center
        )
        Spacer(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
                .background(Color.DarkGray)
        )
        Text(
            text = "ChooseType",
            modifier = textModifier.clickable { onMenuItemClick(Screen.Type) },
            textAlign = TextAlign.Center
        )
    }
}