package com.example.estudiando.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.estudiando.ui.screens.components.PeopleList

@Composable
fun PeopleScreen() {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val numberOfPeople = remember { mutableStateOf("") }
            val numberOfPeopleToShow = remember { mutableIntStateOf(0) }
            Text(
                text = "Personas",
                modifier = Modifier.padding(16.dp),
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
            SearchBar(
                numberOfPeople = numberOfPeople,
                onShowPeopleClick = {
                    numberOfPeopleToShow.intValue = numberOfPeople.value.toIntOrNull() ?: 0
                }
            )
            PeopleList(numberOfPeople = numberOfPeopleToShow.intValue)
        }
    }
}


@Composable
fun SearchBar(numberOfPeople: MutableState<String>, onShowPeopleClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = numberOfPeople.value,
            onValueChange = {
                numberOfPeople.value = it
            },
            placeholder = {
                Text(text = "Number of people")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .weight(1f)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Button(
            onClick = onShowPeopleClick,
            modifier = Modifier
                .padding(start = 16.dp)
        ) {
            Text("Show people")
        }
    }
}
