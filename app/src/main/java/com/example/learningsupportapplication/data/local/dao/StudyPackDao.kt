package com.example.learningsupportapplication.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.learningsupportapplication.domain.model.StudyPack

@Dao
interface StudyPackDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNewStudyPack(studyPack: StudyPack)
}