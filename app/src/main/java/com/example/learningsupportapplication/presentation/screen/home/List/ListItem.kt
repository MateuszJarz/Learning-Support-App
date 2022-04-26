package com.example.learningsupportapplication.presentation.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.learningsupportapplication.ui.theme.*

@ExperimentalMaterialApi
@Composable
fun ListItem(
    title: String,
    onClickButton: () -> Unit,
    onClickIconButton: () -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = LIST_ITEM_PADDING)
            .height(LIST_ITEM_HEIGHT),
        color = MaterialTheme.colors.listItemColor,
        shape = RoundedCornerShape(SMALL_PADDING),
        onClick = {
            onClickButton()
        }

    ) {
        Row(
            modifier = Modifier.padding(all = SMALL_PADDING),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Text(
                modifier = Modifier
                    .padding(start = MEDIUM_PADDING),
                text = title,
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.textItemColor
            )

            IconButton(
                onClick = { onClickIconButton() }
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = null,
                    Modifier.size(MEDIUM_PADDING)
                )

            }

        }
    }
}

@ExperimentalMaterialApi
@Preview()
@Composable
fun ListItemPrev() {
   ListItem(title = "Text", onClickButton = {}) {

   }
}
