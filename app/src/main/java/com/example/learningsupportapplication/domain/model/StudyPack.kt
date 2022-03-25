package com.example.learningsupportapplication.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "study_pack_table")
data class StudyPack(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var studyPackName: String
)
