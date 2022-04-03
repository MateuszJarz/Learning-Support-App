package com.example.learningsupportapplication.data.repository

import androidx.lifecycle.LiveData
import com.example.learningsupportapplication.data.local.dao.StudyCardDao
import com.example.learningsupportapplication.data.local.dao.StudyPackDao
import com.example.learningsupportapplication.domain.model.StudyCard
import com.example.learningsupportapplication.domain.model.StudyPack
import com.example.learningsupportapplication.domain.model.StudyPackRelation
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val studyPackDao: StudyPackDao,
    private val studyCardDao: StudyCardDao
) {

    suspend fun addNewStudyPack(studyPack: StudyPack): Long {
        return studyPackDao.addNewStudyPack(studyPack)
    }

    suspend fun addNewPackWithListOfCards(studyPackRelation: StudyPackRelation) {
        studyPackDao.addNewPackWithListOfCards(studyPackRelation)
    }

    fun getAllStudyPack(): Flow<List<StudyPack>>{
        return studyPackDao.getAllStudyPack()
    }

    suspend fun getStudyPackById(idStudyPack: Int): StudyPack {
        return studyPackDao.getStudyPackById(idStudyPack = idStudyPack)
    }

    fun getStudyCardsByStudyPackId(idStudyPack: Int): List<StudyCard> {
        return studyCardDao.getStudyCardsByStudyPackId(idStudyPack = idStudyPack)
    }

}