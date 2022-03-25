package com.example.learningsupportapplication.data.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy

interface StudyPackDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNewPackage(pack: Package)
}