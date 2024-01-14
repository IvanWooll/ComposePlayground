package com.fs.composeplayground.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fs.composeplayground.ui.composables.PersonItemState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fs.composeplayground.ui.composables.PersonItem
import com.fs.composeplayground.viewmodel.PeopleViewModel

@Composable
fun PeopleScreen(viewModel: PeopleViewModel) {
    val state = viewModel.peopleState.collectAsStateWithLifecycle(emptyList())

    PeopleScreenContent(
        personItems = state.value,
        onPersonClick = viewModel::onPersonClicked
    )

}

@Composable
@Preview(showBackground = true)
fun PeopleScreenContent(
    personItems: List<PersonItemState> = emptyList(),
    onPersonClick: (personItemState: PersonItemState) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "People", modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp), textAlign = TextAlign.Center
        )
        LazyColumn {
            items(personItems) { personItemState ->
                PersonItem(state = personItemState, modifier = Modifier.clickable { onPersonClick(personItemState) })
            }
        }
    }

}