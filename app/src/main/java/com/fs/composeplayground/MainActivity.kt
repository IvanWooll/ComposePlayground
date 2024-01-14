package com.fs.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fs.composeplayground.ui.composables.Menu
import com.fs.composeplayground.ui.composables.Screen
import com.fs.composeplayground.ui.screens.AddNameScreen
import com.fs.composeplayground.ui.screens.AddNameScreenContent
import com.fs.composeplayground.ui.screens.PeopleScreen
import com.fs.composeplayground.ui.screens.PeopleScreenContent
import com.fs.composeplayground.ui.screens.TypeScreen
import com.fs.composeplayground.ui.screens.TypeScreenContent
import com.fs.composeplayground.ui.theme.ComposePlaygroundTheme
import com.fs.composeplayground.viewmodel.AddNameViewModel
import com.fs.composeplayground.viewmodel.PeopleViewModel
import com.fs.composeplayground.viewmodel.TypeViewModel

class MainActivity : ComponentActivity() {

    private val addNameViewModel by viewModels<AddNameViewModel>()
    private val peopleViewModel by viewModels<PeopleViewModel>()
    private val typeViewModel by viewModels<TypeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                // A surface container using the 'background' color from the theme
                App(addNameViewModel, peopleViewModel, typeViewModel)
            }
        }
    }
}

@Composable
fun App(addNameViewModel: AddNameViewModel, peopleViewModel: PeopleViewModel, typeViewModel: TypeViewModel) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        val navController = rememberNavController()
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            NavHost(
                navController, startDestination = "people", modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                composable("add_name") { AddNameScreen(addNameViewModel) }
                composable("people") { PeopleScreen(peopleViewModel) }
                composable("types") { TypeScreen(typeViewModel) }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Menu {
                    val screen = when (it) {
                        Screen.AddName -> "add_name"
                        Screen.People -> "people"
                        Screen.Type -> "types"
                    }
                    navController.navigate(screen)
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AppContent() {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            val navController = rememberNavController()
            NavHost(
                navController, startDestination = "people"
            ) {
                composable("add_name") { AddNameScreenContent() }
                composable("people") { PeopleScreenContent() }
                composable("types") { TypeScreenContent() }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.DarkGray)
                .heightIn(40.dp)
        ) {

        }
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//        ) {
//            Menu {
//                val screen = when (it) {
//                    Screen.AddName -> "add_name"
//                    Screen.People -> "people"
//                    Screen.Type -> "types"
//                }
//                navController.navigate(screen)
//            }
//        }
    }

}

