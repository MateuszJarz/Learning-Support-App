package com.example.learningsupportapplication.data.local.dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.learningsupportapplication.domain.model.StudyCard
import com.example.learningsupportapplication.domain.model.StudyPack
import com.example.learningsupportapplication.domain.model.StudyPackRelation
import kotlinx.coroutines.flow.Flow


@Dao
interface StudyPackDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addNewStudyPack(studyPack: StudyPack): Long

    @Query("SELECT * FROM study_pack_table ORDER BY id ASC")
    fun getAllStudyPack(): Flow<List<StudyPack>>

    @Insert
    suspend fun insertAllStudyCard(studyCard: List<StudyCard>)

    @Query("SELECT * FROM study_pack_table WHERE id LIKE :idStudyPack")
    suspend fun getStudyPackById(idStudyPack: Int): StudyPack

    suspend fun addNewPackWithListOfCards(studyPackRelation: StudyPackRelation) {
        val idStudyPack = studyPackRelation.studyPack.id
        studyPackRelation.studyCard.forEach { it.idStudyPack = idStudyPack }
        insertAllStudyCard(studyPackRelation.studyCard)

    }
}