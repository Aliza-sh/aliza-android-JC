package com.aliza.alizaandroidJC.ui.basic_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun HomeScreen() {

    val navController = rememberNavController()
    val textFieldState = remember { mutableStateOf("") }

    NavigationGraph(navController, textFieldState)

}

@Composable
fun NavigationGraph(navController: NavHostController, textFieldState: MutableState<String>) {
    NavHost(navController = navController, startDestination = "first_screen") {
        composable("first_screen") {
            FirstScreen(textFieldState = textFieldState,
                { textFieldState.value = it },
                onButtonClick = {
                    if (textFieldState.value.isNotEmpty()) {
                        navController.navigate("second_screen/${textFieldState.value}")
                    } else {
                        textFieldState.value = "Please enter some text"
                    }
                }
            )
        }
        composable(
            route = "second_screen/{arg_key}",
            arguments = listOf(navArgument("arg_key") { type = NavType.StringType })
        ) { backStackEntry ->
            SecondScreen(backStackEntry.arguments?.getString("arg_key") ?: "") {
                navController.navigateUp()
            }
        }
    }
}

