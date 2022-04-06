package com.example.learningsupportapplication.domain.model

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "study_card_table")
data class StudyCard(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var idStudyPack: Int,
    val firstPage: String,
    val secondPage: String,
    val image: Bitmap? = null,

    /* var correctAnswer: Int = 0,
     var wrongAnswer: Int = 0,
     var subOrderCorrectAnswer: Int = 0,
     val subOrderWrongAnswer: Int = 0,
     var inProgress: Boolean = false*/


    // number of correct and wrong Answer for flashcard
)