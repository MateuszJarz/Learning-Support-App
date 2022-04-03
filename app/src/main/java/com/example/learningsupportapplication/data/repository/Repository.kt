package com.example.learningsupportapplication.data.repository

import com.example.learningsupportapplication.data.local.dao.StudyPackDao
import com.example.learningsupportapplication.domain.model.StudyPack
import com.example.learningsupportapplication.domain.model.StudyPackRelation
import javax.inject.Inject

class Repository @Inject constructor(
    private val studyPackDao: StudyPackDao
) {

    suspend fun addNewStudyPack(studyPack: StudyPack): Long {
        return studyPackDao.addNewStudyPack(studyPack)
    }

    suspend fun addNewPackWithListOfCards(studyPackRelation: StudyPackRelation) {
        studyPackDao.addNewPackWithListOfCards(studyPackRelation)
    }

    suspend fun getStudyPackById(idStudyPack: Int): StudyPack {
        return studyPackDao.getStudyPackById(idStudyPack = idStudyPack)
    }

}