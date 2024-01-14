package com.fs.composeplayground.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fs.composeplayground.data.Type

@Composable
fun PersonItem(state: PersonItemState, modifier: Modifier = Modifier) {
    val color = when (state.type) {
        Type.Red -> Color.Red
        Type.Blue -> Color.Blue
        Type.None -> Color.LightGray
    }
    val colour by remember {
        mutableStateOf(color)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp)
    ) {
        Text(
            modifier = Modifier
                .height(30.dp)
                .wrapContentSize()
                .padding(end = 8.dp),
            text = state.name
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .background(colour)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun BluePersonPreview() {
    PersonItem(PersonItemState(name = "Blue person", type = Type.Blue))
}

@Composable
@Preview(showBackground = true)
fun RedPersonPreview() {
    PersonItem(PersonItemState(name = "Red person", type = Type.Red))
}

data class PersonItemState(val name: String, val type: Type)