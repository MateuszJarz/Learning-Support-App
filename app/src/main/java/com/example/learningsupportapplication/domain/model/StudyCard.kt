package com.example.learningsupportapplication.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "study_card_table")
data class StudyCard(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var idStudyPack: Int,
    val firstPage: String,
    val secondPage: String,

    /* var correctAnswer: Int = 0,
     var wrongAnswer: Int = 0,
     var subOrderCorrectAnswer: Int = 0,
     val subOrderWrongAnswer: Int = 0,
     var inProgress: Boolean = false*/

// val Image: Bitmap? = null,
    // number of correct and wrong Answer for flashcard
)