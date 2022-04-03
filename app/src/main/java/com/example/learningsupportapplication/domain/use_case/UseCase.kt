package com.example.learningsupportapplication.domain.use_case

import com.example.learningsupportapplication.domain.use_case.add_new_pack_with_list_of_cards.AddNewPackWithListOfCards
import com.example.learningsupportapplication.domain.use_case.add_new_study_pack.AddNewStudyPack
import com.example.learningsupportapplication.domain.use_case.get_all_study_pack.GetAllStudyPack
import com.example.learningsupportapplication.domain.use_case.get_study_cards_by_study_pack_id.GetStudyCardsByStudyPackId
import com.example.learningsupportapplication.domain.use_case.get_study_pack_by_id.GetStudyPackById

data class UseCase(
    val addNewPackWithListOfCards: AddNewPackWithListOfCards,
    val addNewStudyPack: AddNewStudyPack,
    val getStudyPackById: GetStudyPackById,
    val getStudyCardsByStudyPackId: GetStudyCardsByStudyPackId,
    val getAllStudyPack: GetAllStudyPack
)