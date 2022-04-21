package com.example.learningsupportapplication.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "study_pack_table", indices = [Index(value = ["studyPackName"], unique = true)])
data class StudyPack(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "studyPackName")
    var studyPackName: String
)
