package com.example.learningsupportapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.learningsupportapplication.navigation.SetupNavGraph
import com.example.learningsupportapplication.ui.theme.LearningSupportApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningSupportApplicationTheme {
                navHostController = rememberNavController()
                SetupNavGraph(navController = navHostController)
            }
        }
    }
}

