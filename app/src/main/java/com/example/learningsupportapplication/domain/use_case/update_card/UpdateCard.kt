package com.example.learningsupportapplication.domain.use_case.update_card

import com.example.learningsupportapplication.data.repository.Repository
import com.example.learningsupportapplication.domain.model.StudyCard

class UpdateCard(
   private val repository: Repository
) {

    suspend operator fun invoke(studyCard: StudyCard){
        return repository.updateStudyCard(studyCard = studyCard)
    }
}