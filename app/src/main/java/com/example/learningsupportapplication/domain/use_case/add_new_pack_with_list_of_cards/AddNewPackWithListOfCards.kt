package com.example.learningsupportapplication.domain.use_case.add_new_pack_with_list_of_cards

import com.example.learningsupportapplication.data.repository.Repository
import com.example.learningsupportapplication.domain.model.StudyPackRelation

class AddNewPackWithListOfCards(
    private val repository: Repository
) {
    suspend operator fun invoke(studyPackRelation: StudyPackRelation) {
        repository.addNewPackWithListOfCards(studyPackRelation)
    }
}