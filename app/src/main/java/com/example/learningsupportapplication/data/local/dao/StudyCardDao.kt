package com.example.learningsupportapplication.data.local.dao

import androidx.room.*
import com.example.learningsupportapplication.domain.model.StudyCard

@Dao
interface StudyCardDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE) // Insert the data
    suspend fun addNewStudyCard(studyCard: StudyCard)

    @Query("SELECT * FROM study_card_table  WHERE idStudyPack  LIKE :idStudyPack ")
    suspend fun getStudyCardsByStudyPackId(idStudyPack: Int): MutableList<StudyCard>

    @Delete
    suspend fun deleteStudyCard(studyCard: StudyCard)
}