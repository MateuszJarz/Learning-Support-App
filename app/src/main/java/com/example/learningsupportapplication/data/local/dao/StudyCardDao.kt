package com.example.learningsupportapplication.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.learningsupportapplication.domain.model.StudyCard

@Dao
interface StudyCardDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE) // Insert the data
    suspend fun addNewStudyCard(studyCard: StudyCard)
}