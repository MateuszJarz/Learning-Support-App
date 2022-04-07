package com.example.learningsupportapplication.domain.model

import androidx.annotation.DrawableRes
import com.example.learningsupportapplication.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    object First: OnBoardingPage(
        image = R.drawable.ic_launcher_background,
        title = "Greetings",
        description = "Are you looking for new ways to learn faster? Because if you are then we have a grate news for you!"
    )
    object Second: OnBoardingPage(
        image = R.drawable.ic_launcher_background,
        title = "Materials",
        description = "Add your own materials, and create great fiches!"
    )
    object Third: OnBoardingPage(
        image = R.drawable.ic_launcher_background,
        title = "Learn",
        description = "Use the repetition method, which will make you learn faster and more efficiently! "
    )
}
