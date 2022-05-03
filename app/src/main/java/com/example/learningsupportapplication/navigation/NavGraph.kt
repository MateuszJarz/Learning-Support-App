package com.example.learningsupportapplication.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.learningsupportapplication.presentation.screen.add_new_card.AddNewStudyCard
import com.example.learningsupportapplication.presentation.screen.create_study_pack.CreateStudyPack
import com.example.learningsupportapplication.presentation.screen.edit_card.EditStudyCard
import com.example.learningsupportapplication.presentation.screen.edit_study_pack.EditStudyPackScreen
import com.example.learningsupportapplication.presentation.screen.education_process.EducationProcess
import com.example.learningsupportapplication.presentation.screen.home.HomeScreen
import com.example.learningsupportapplication.presentation.screen.welcome.WelcomeScreen
import com.example.util.Constants.STUDY_CARD_ARGUMENT_KEY
import com.example.util.Constants.STUDY_PACK_ARGUMENT_KEY
import com.example.util.Constants.STUDY_PACK_EDIT_ARGUMENT_KEY
import com.example.util.Constants.STUDY_PACK_EDU_ARGUMENT_KEY
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Splash.route) {

        }
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(navHostController = navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        // Education Process
        composable(
            route = Screen.EducationProcess.route,
            arguments = listOf(navArgument(STUDY_PACK_EDU_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) {
            EducationProcess(navController = navController)
        }


        // Create Process
        composable(
            route = Screen.CreateStudyPack.route

        ) {
            CreateStudyPack(navController = navController)
        }

        composable(
            route = Screen.AddNewStudyCard.route,
            arguments = listOf(navArgument(STUDY_PACK_ARGUMENT_KEY) {
                type = NavType.IntType
            })

        ) {
            AddNewStudyCard(navController = navController)
        }

        // Edit Process
        composable(
            route = Screen.EditStudyPack.route,
            arguments = listOf(navArgument(STUDY_PACK_EDIT_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) {
            EditStudyPackScreen(navController = navController)
        }
        composable(
            route = Screen.EditStudyCard.route,
            arguments = listOf(navArgument(STUDY_CARD_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) {
            EditStudyCard(navController = navController)
        }
    }
}



