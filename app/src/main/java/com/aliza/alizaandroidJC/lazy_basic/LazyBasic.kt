package com.aliza.alizaandroidJC.lazy_basic

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ShowUsers(
    topUsers: List<User>,
    otherUsers: List<User>,
    onItemClick: (String) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        // LazyRow at the top
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            contentPadding = PaddingValues(top = 16.dp, end = 16.dp, start = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(topUsers) {
                Item(it) { name -> onItemClick(name) }
            }
        }
        // Margin
        Spacer(modifier = Modifier.height(16.dp))
        // LazyColumn at the bottom
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight(),
            contentPadding = PaddingValues(bottom = 16.dp, end = 16.dp, start = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(otherUsers) {
                Item(it) { name -> onItemClick(name) }
            }
        }
    }
}

@Composable
fun Item(user: User, onItemClick: (String) -> Unit) {
    Card(
        onClick = { onItemClick(user.name) },
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth(),
        enabled = true,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = user.color,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ),
        elevation = CardDefaults.cardElevation(8.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.secondary)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Text(text = user.rank.toString(), modifier = Modifier.padding(end = 24.dp))
            Text(text = user.name)
        }
    }
}