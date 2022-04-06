package com.example.learningsupportapplication.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.learningsupportapplication.domain.model.StudyCard
import kotlinx.coroutines.flow.Flow

@Dao
interface StudyCardDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE) // Insert the data
    suspend fun addNewStudyCard(studyCard: StudyCard)

    @Query("SELECT * FROM study_card_table  WHERE idStudyPack  LIKE :idStudyPack ")
    fun getStudyCardsByStudyPackId(idStudyPack: Int) : MutableList<StudyCard>
}