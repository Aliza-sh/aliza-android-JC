package com.aliza.alizaandroidJC

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aliza.alizaandroidJC.lazy_basic.LazyBasicViewModel
import com.aliza.alizaandroidJC.lazy_basic.ShowUsers
import com.aliza.alizaandroidJC.lazy_basic.otherUsers
import com.aliza.alizaandroidJC.lazy_basic.topUsers
import com.aliza.alizaandroidJC.ui.theme.AlizaAndroidJCTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<LazyBasicViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlizaAndroidJCTheme {
                MainScreen(viewModel)
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: LazyBasicViewModel) {

    // Define a list of items
    val topUsers = viewModel.topUsers.observeAsState(emptyList()).value
    val otherUsers = viewModel.users.observeAsState(emptyList()).value

    // Remember the SnackbarHostState to show the snackbar
    val snackbarHostState = remember { SnackbarHostState() }

    // Launch a coroutine to show the snackbar
    val coroutineScope = rememberCoroutineScope()

    // Scaffold to hold the SnackbarHost, Lazies
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            ShowUsers(topUsers = topUsers, otherUsers = otherUsers) {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar("You clicked: $it")
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AlizaAndroidJCTheme {

        val previewViewModel = LazyBasicViewModel()

        // Remember the SnackbarHostState to show the snackbar
        val snackbarHostState = remember { SnackbarHostState() }

        // Launch a coroutine to show the snackbar
        val coroutineScope = rememberCoroutineScope()

        // Scaffold to hold the SnackbarHost and LazyColumn
        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) }
        ) {
            ShowUsers(topUsers = topUsers, otherUsers = otherUsers) {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar("You clicked: $it")
                }
            }
        }
    }
}