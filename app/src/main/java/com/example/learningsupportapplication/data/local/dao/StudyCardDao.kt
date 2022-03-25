package com.example.learningsupportapplication.data.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.learningsupportapplication.domain.model.StudyCard

interface StudyCardDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE) // Insert the data
    suspend fun addNewCard(studyCard: StudyCard)
}