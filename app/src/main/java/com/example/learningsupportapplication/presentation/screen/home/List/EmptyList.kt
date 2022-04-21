package com.example.learningsupportapplication.presentation.screen.home.List

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.learningsupportapplication.R
import com.example.learningsupportapplication.ui.theme.MediumGray
import com.example.learningsupportapplication.ui.theme.SIZE_SAD_ICON


@Composable
fun EmptyList() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(SIZE_SAD_ICON),
            painter = painterResource(id = R.drawable.ic_sad_face),
            contentDescription = "Sad Face Icon",
            tint = MediumGray
        )
        Text(
            text = "No Package Found.",
            color = MediumGray,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.h6.fontSize
        )
    }
}

@Preview
@Composable
fun EmptyContentPreview() {
    EmptyList()
}