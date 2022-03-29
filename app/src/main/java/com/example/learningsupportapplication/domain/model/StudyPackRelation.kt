package com.example.learningsupportapplication.domain.model

import androidx.room.Embedded
import androidx.room.Relation

data class StudyPackRelation(
    @Embedded val studyPack: StudyPack,
    @Relation(
        parentColumn = "id",
        entityColumn = "idStudyPack",
        entity = StudyCard::class
    )
    var studyCard: List<StudyCard>
)