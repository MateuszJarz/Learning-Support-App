package com.example.learningsupportapplication.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.learningsupportapplication.domain.model.StudyCard
import com.example.learningsupportapplication.domain.model.StudyPack
import com.example.learningsupportapplication.domain.model.StudyPackRelation

@Dao
interface StudyPackDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNewStudyPack(studyPack: StudyPack)

    @Insert
    suspend fun insertAllStudyCard(studyCard: List<StudyCard>)

    suspend fun addNewPackWithListOfCards(studyPackRelation: StudyPackRelation) {
        val idStudyPack = studyPackRelation.studyPack.id
        studyPackRelation.studyCard.forEach { it.idStudyPack = idStudyPack }
        insertAllStudyCard(studyPackRelation.studyCard)

    }
}