package com.example.estudiando.ui.screens.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable

@Composable
fun PeopleList(numberOfPeople: Int) {
    LazyColumn {
        items(numberOfPeople) {
            PersonCard()
        }
    }
}