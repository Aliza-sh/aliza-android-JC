package com.aliza.alizaandroidJC

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen(viewModel)
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        val previewViewModel = MainViewModel()
        MainScreen(previewViewModel)
    }

}

@Composable
fun MainScreen(viewModel: MainViewModel) {

    val textFieldState by viewModel.textFieldValue.observeAsState("")
    val users = viewModel.users.observeAsState(emptyList()).value

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        StudentsShowNames(
            users, { viewModel.addUser(User(textFieldState)) },
            textFieldState, { viewModel.textFieldChangedText(it) }
        )
    }

}

@Composable
fun StudentsShowNames(
    users: List<User>, onButtonClicked: () -> Unit,
    textFieldValue: String, onTextFieldValueChanged: (String) -> Unit
) {

    users.forEach {
        Text(
            text = it.name,
            style = MaterialTheme.typography.titleLarge
        )
    }

    OutlinedTextField(
        label = { Text("Enter text") },
        value = textFieldValue,
        onValueChange = onTextFieldValueChanged
    )

    Button(onClick = onButtonClicked) {
        Text(text = "add name")
    }

}