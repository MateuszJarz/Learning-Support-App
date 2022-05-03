package com.example.learningsupportapplication.presentation.screen.edit_study_pack

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.learningsupportapplication.R
import com.example.learningsupportapplication.domain.model.StudyCard
import com.example.learningsupportapplication.navigation.Screen
import com.example.learningsupportapplication.ui.theme.*

@ExperimentalMaterialApi
@Composable
fun EditStudyPackList(
    navController: NavHostController,
    studyCards: List<StudyCard>,
    editStudyPackViewModel: EditStudyPackViewModel
) {
    LazyColumn(
        contentPadding = PaddingValues(SMALL_PADDING),
        verticalArrangement = Arrangement.Center
    ) {
        items(studyCards) { card ->

            StudyPackListItem(
                studyCard = card,
                onClickNavigate = {
                    navController.navigate(Screen.EditStudyCard.passStudyCardId(studyCardId = card.id))
                },
                onDeleteClicked = {

                    editStudyPackViewModel.deleteStudyCard(studyCard = card)

                }
            )

            /* Surface() {
                 item.image?.let { Image(bitmap = it.asImageBitmap(), contentDescription = null) }
                 Text(text = item.firstPage)

             }*/

        }
    }
}

@ExperimentalMaterialApi
@Composable
fun StudyPackListItem(
    studyCard: StudyCard,
    onClickNavigate: () -> Unit,
    onDeleteClicked: () -> Unit,
) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = LIST_ITEM_PADDING)
            .height(LIST_ITEM_HEIGHT),
        color = MaterialTheme.colors.listItemColor,
        shape = RoundedCornerShape(SMALL_PADDING),
        onClick = {
            onClickNavigate()
        }

    ) {
        Row(
            modifier = Modifier.padding(all = SMALL_PADDING),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            studyCard.image.let { bitmap ->
                if (bitmap != null) {
                    Image(
                        modifier = Modifier.size(width = 35.dp, height = 35.dp),
                        bitmap = bitmap.asImageBitmap(),
                        contentDescription = "Bitmap Image",
                        contentScale = ContentScale.Crop,

                        )
                } else {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                }
            }

            Text(
                modifier = Modifier
                    .padding(start = MEDIUM_PADDING),
                text = studyCard.firstPage,
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.textItemColor,
                maxLines = 1,
                overflow = TextOverflow.Clip

            )

            IconButton(
                onClick = { onDeleteClicked() }
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Icon",

                    )

            }

        }
    }
}