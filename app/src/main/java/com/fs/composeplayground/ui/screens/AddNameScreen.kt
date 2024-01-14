package com.fs.composeplayground.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fs.composeplayground.viewmodel.AddNameViewModel


@Composable
fun AddNameScreen(viewModel: AddNameViewModel) {
    AddNameScreenContent(onNameSubmitted = viewModel::onNameSubmitted)
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
@Preview(showBackground = true)
fun AddNameScreenContent(onNameSubmitted: (String) -> Unit = {}) {
    val keyboardController = LocalSoftwareKeyboardController.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Add Name", modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp), textAlign = TextAlign.Center
        )

        var name by remember {
            mutableStateOf("")
        }
        TextField(
            modifier = Modifier.padding(bottom = 8.dp),
            value = name,
            onValueChange = { value -> name = value },
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences)
        )
        Button(onClick = {
            onNameSubmitted(name)
            name = ""
            keyboardController?.hide()
        }) {
            Text(text = "Submit")
        }
    }
}