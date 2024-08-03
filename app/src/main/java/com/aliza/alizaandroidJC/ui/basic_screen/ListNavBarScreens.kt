package com.aliza.alizaandroidJC.ui.basic_screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ListNavBarScreens(val route: String, val title: String, val icon: ImageVector) {
    data object Home : ListNavBarScreens("home", "Home", Icons.Default.Home)
    data object Search : ListNavBarScreens("favorite", "Favorite", Icons.Default.Favorite)
    data object Profile : ListNavBarScreens("profile", "Profile", Icons.Default.Person)
}