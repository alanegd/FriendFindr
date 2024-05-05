package com.example.estudiando.ui.screens.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun PersonCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            GlideImage(
                imageModel = { "https://upload.wikimedia.org/wikipedia/en/8/88/Winston_Smith.jpg"},
                modifier = Modifier.size(100.dp)
            )
            Column(modifier = Modifier.weight(1f).padding(start = 18.dp)) {
                Text(text = "Winston")
                Text(text = "Smith")
                Text(text = "wsmith@gmail.com")
                Text(text = "1234567890")
            }
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Favorite, "Favorite", tint = MaterialTheme.colorScheme.primary)
            }
        }
    }
}


