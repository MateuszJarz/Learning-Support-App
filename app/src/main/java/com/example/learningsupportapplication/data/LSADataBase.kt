package com.example.learningsupportapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.learningsupportapplication.data.local.converter.PhotoConverter
import com.example.learningsupportapplication.data.local.dao.StudyCardDao
import com.example.learningsupportapplication.data.local.dao.StudyPackDao
import com.example.learningsupportapplication.domain.model.StudyCard
import com.example.learningsupportapplication.domain.model.StudyPack

@Database(entities = [StudyCard::class, StudyPack::class], version = 1, exportSchema = false)
@TypeConverters(PhotoConverter::class)
abstract class LSADataBase : RoomDatabase() {
    abstract fun studyCardDao(): StudyCardDao
    abstract fun studyPackDao(): StudyPackDao
}
