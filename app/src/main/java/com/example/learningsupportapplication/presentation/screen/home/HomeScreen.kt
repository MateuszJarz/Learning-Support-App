package com.example.learningsupportapplication.presentation.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.learningsupportapplication.navigation.Screen
import com.example.learningsupportapplication.presentation.common.StudyPackList
import com.example.learningsupportapplication.ui.theme.BORDER_SIZE
import com.example.learningsupportapplication.ui.theme.LARGE_PADDING
import com.example.learningsupportapplication.ui.theme.SMALL_PADDING

/*
    * 1. Field with button to create new StudyPack
    * - button
    * 2. List with all created StudyPack
    * - start button
    * - name of pack
    * - */

@ExperimentalMaterialApi
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController,
    homeScreenViewModel: HomeScreenViewModel = hiltViewModel()
) {

    val studyPackages = homeScreenViewModel.getAllStudyPack
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        topBar = {
            TopAppBar() {
            }
        }, content = {
            StudyPackList(
                studyPackages = studyPackages,
                navController = navController
            )
        }
        ,
        bottomBar = {

        }
    )


}


@Composable
fun HomeCreateStudyPack(
    navController: NavHostController
) {

    Surface(
        modifier = Modifier
            .width(322.dp)
            .height(96.dp),
        shape = RoundedCornerShape(LARGE_PADDING),
        border = BorderStroke(BORDER_SIZE, Color.Black),

        ) {
        Row(
            modifier = Modifier
                .padding(all = SMALL_PADDING),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Text(
                modifier = Modifier
                    .padding(start = SMALL_PADDING),
                text = "Add new Study Pack!",
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
                fontWeight = FontWeight.Bold

            )


            Button(
                modifier = Modifier
                    .width(95.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                shape = RoundedCornerShape(SMALL_PADDING),
                border = BorderStroke(BORDER_SIZE, Color.Black),
                onClick = { navController.navigate(Screen.CreateStudyPack.route) }
            ) {
                Text(
                    text = "CREATE",
                    color = Color.Black
                )
            }
        }
    }
}



