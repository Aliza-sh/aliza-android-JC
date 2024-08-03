package com.aliza.alizaandroidJC.ui.basic_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FirstScreen(
    textFieldState: MutableState<String>,
    onTextFieldValueChanged: (String) -> Unit,
    onButtonClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("First Screen")
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = textFieldState.value,
            onValueChange = onTextFieldValueChanged,
            label = { Text("Enter text") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onButtonClick) {
            Text("Go to Details")
        }
    }
}