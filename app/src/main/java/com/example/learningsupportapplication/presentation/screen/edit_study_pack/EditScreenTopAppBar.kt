package com.example.learningsupportapplication.presentation.screen.edit_study_pack

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun EditScreenTopBar(
    navController: NavHostController
) {
    EditScreenTopBarContent(
        onBackClicked = {
            navController.popBackStack()
        },

        )
}

@Composable
fun EditScreenTopBarContent(
    onBackClicked: () -> Unit,
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.background,
        navigationIcon = {
            IconButton(onClick = onBackClicked) {
                Icon(Icons.Filled.ArrowBack, "Arrow Icon")
            }
        },
        title = {
            Text(
                text = "Learning Cards",
                fontSize = MaterialTheme.typography.subtitle1.fontSize
            )
        },

        )

}

