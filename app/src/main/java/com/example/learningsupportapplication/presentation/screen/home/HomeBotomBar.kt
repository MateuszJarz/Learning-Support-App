package com.example.learningsupportapplication.presentation.screen.home

import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.learningsupportapplication.ui.theme.bottomAppBarBackgroundColor


@Composable
fun AppBottomBar(
    navController: NavHostController,
    onAddClicked: () -> Unit,
    shape: Shape
) {

    BottomAppBar(
        modifier = Modifier.height(50.dp),
        backgroundColor = MaterialTheme.colors.bottomAppBarBackgroundColor,
        cutoutShape = shape

    ){

    }


}
