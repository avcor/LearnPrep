package com.example.learnprep.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.learnprep.room.dao.LibraryDao
import com.example.learnprep.room.dao.MarksDao
import com.example.learnprep.room.dao.SubjectDao
import com.example.learnprep.room.dao.UserDao
import com.example.learnprep.room.entities.LibraryCard
import com.example.learnprep.room.entities.Marks
import com.example.learnprep.room.entities.Subject
import com.example.learnprep.room.entities.User
import com.example.learnprep.room.entities.UserSubjectCrossRef

@Database(
    entities = [User::class, LibraryCard::class, Subject::class, Marks::class, UserSubjectCrossRef::class],
    version = 5,
    exportSchema = true,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun libraryDao(): LibraryDao
    abstract fun subjectDao(): SubjectDao
    abstract fun markDao(): MarksDao

}