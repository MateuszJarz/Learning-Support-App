package com.example.learningsupportapplication.presentation.screen.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.learningsupportapplication.ui.theme.LARGE_PADDING
import com.example.learningsupportapplication.ui.theme.textItemColor

@Composable
fun HomeTopBar(
    navController: NavHostController,
    onDeleteAllConfirmed: () -> Unit
) {
    HomeTopBarContent(
        onDeleteAllConfirmed = {
            onDeleteAllConfirmed()
        },
        onSearchClicked = {

        }
    )
}

@Composable
fun HomeTopBarContent(
    onDeleteAllConfirmed: () -> Unit,
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
                onDeleteAllConfirmed = onDeleteAllConfirmed,
                onSearchClicked = onSearchClicked
            )
        }
    )

}

@Composable
fun ListAppBarAction(
    onDeleteAllConfirmed: () -> Unit,
    onSearchClicked: () -> Unit
) {
    SearchAction(onSearchClicked = { onSearchClicked() })
    DropDownMenuAction(onDeleteAllConfirmed = { onDeleteAllConfirmed() })

}

@Composable
fun DropDownMenuAction(
    onDeleteAllConfirmed: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    IconButton(
        onClick = { expanded = true }
    ) {
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "Delete ALl",
            tint = MaterialTheme.colors.textItemColor
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(onClick = {
                expanded = true
                onDeleteAllConfirmed()
            }
            ) {
                Text(
                    modifier = Modifier.padding(start = LARGE_PADDING),
                    text = "Delete All",
                    style = MaterialTheme.typography.subtitle2
                )
            }
        }

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