package com.example.learningsupportapplication.domain.use_case.get_study_card

import com.example.learningsupportapplication.data.repository.Repository
import com.example.learningsupportapplication.domain.model.StudyCard

class GetStudyCard(
    private val repository: Repository
) {
    suspend operator fun invoke(idStudyCard: Int): StudyCard {
        return repository.getStudyCard(idStudyCard = idStudyCard)
    }
}