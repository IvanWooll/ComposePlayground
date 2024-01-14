package com.fs.composeplayground.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fs.composeplayground.data.Type
import com.fs.composeplayground.viewmodel.TypeViewModel

@Composable
fun TypeScreen(viewModel: TypeViewModel) {

    val state = viewModel.type.collectAsStateWithLifecycle()
    TypeScreenContent(type = state.value, onTypeChanged = viewModel::onTypeChanged)
}

@Composable
@Preview(showBackground = true)
fun TypeScreenContent(type: Type = Type.None, onTypeChanged: (Type) -> Unit = {}) {
    var currentType by remember {
        mutableStateOf(type)
    }

    fun onBlueSelected() {
        currentType = Type.Blue
        onTypeChanged(currentType)
    }

    fun onRedSelected() {
        currentType = Type.Red
        onTypeChanged(Type.Red)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Type", modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp), textAlign = TextAlign.Center
        )

        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
            ) {
                RadioButton(selected = currentType == Type.Blue, onClick = ::onBlueSelected)
                Text(
                    text = "Blue", modifier = Modifier
                        .fillMaxHeight()
                        .wrapContentSize()
                        .clickable { onBlueSelected() },
                    color = Color.Blue
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .height(30.dp)
            ) {
                RadioButton(selected = currentType == Type.Red, onClick = ::onRedSelected)
                Text(
                    text = "Red", modifier = Modifier
                        .fillMaxHeight()
                        .wrapContentSize()
                        .clickable { onRedSelected() },
                    color = Color.Red
                )
            }
        }

    }

}