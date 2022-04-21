package com.example.learningsupportapplication.presentation.screen.home

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.learningsupportapplication.ui.theme.textItemColor

@Composable
fun HomeTopBar(
    navController: NavHostController
) {
    HomeTopBarContent(
        onButtonClicked = {

        },
        onSearchClicked = {

        }
    )
}

@Composable
fun HomeTopBarContent(
    onButtonClicked: () -> Unit,
    onSearchClicked: () -> Unit
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
            ListAppBarAction(
                onButtonClicked = onButtonClicked,
                onSearchClicked = onSearchClicked
            )
        }
    )

}

@Composable
fun ListAppBarAction(
    onButtonClicked: () -> Unit,
    onSearchClicked: () -> Unit
) {
    SearchAction(onSearchClicked = { onSearchClicked() })
    DropDownMenuAction(onButtonClicked = { onButtonClicked() })

}

@Composable
fun DropDownMenuAction(
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

@Composable
fun SearchAction(
    onSearchClicked: () -> Unit
) {

    IconButton(
        onClick = {
            onSearchClicked()
        }
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search Icon",
            tint = MaterialTheme.colors.textItemColor
        )
    }
}