package com.example.learningsupportapplication.presentation.screen.home

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.learningsupportapplication.navigation.Screen
import com.example.learningsupportapplication.ui.theme.textItemColor

@Composable
fun HomeTopBar(
    navController: NavHostController
) {
    HomeTopBarContent(
        onAddClicked = {
            navController.navigate(Screen.CreateStudyPack.route)
        }
    )
}

@Composable
fun HomeTopBarContent(
    onAddClicked: () -> Unit
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.background,
        title = {
            Text(
                text = "Learning Packages",
                fontSize = MaterialTheme.typography.subtitle1.fontSize
            )
        },
        actions = {
            DropDownMenu {
                onAddClicked()
            }
        }
    )

}

@Composable
fun ListAppBarAction(
    onButtonClicked: () -> Unit
) {
    DropDownMenu(onButtonClicked = {onButtonClicked()})

}

@Composable
fun DropDownMenu(
    onButtonClicked: () -> Unit
) {

    IconButton(
        onClick = {
            onButtonClicked()
        }
    ) {
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "Add Icon",
            tint = MaterialTheme.colors.textItemColor
        )
    }
}