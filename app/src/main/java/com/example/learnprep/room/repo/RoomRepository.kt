package com.example.learnprep.room.repo

import com.example.learnprep.room.db.AppDatabase
import com.example.learnprep.room.entities.LibraryCard
import com.example.learnprep.room.entities.Marks
import com.example.learnprep.room.entities.Subject
import com.example.learnprep.room.entities.User
import com.example.learnprep.room.entities.UserAndLibCard
import com.example.learnprep.room.entities.UserAndMarks
import com.example.learnprep.room.entities.UserAndSubjects
import com.example.learnprep.room.entities.UserSubjectCrossRef

class RoomRepository(private val db: AppDatabase) {

    suspend fun insertUser(list: List<User>) {
        db.userDao().insertAllUser(list)
    }

    suspend fun getUserAndCard(): List<UserAndLibCard> {
        return db.userDao().getUserWithCards()
    }

    suspend fun insertLibraryCard(list: List<LibraryCard>) {
        db.libraryDao().insertLibraryCardList(list = list)
    }

    suspend fun insertSubjects(list: List<Subject>) {
        db.subjectDao().insertSubject(list)
    }

    suspend fun insertMarks(list: List<Marks>) {
        db.markDao().insertMarksList(list)
    }

    suspend fun getUserAndMarks(): List<UserAndMarks> {
        return db.userDao().getUserWithMarks()
    }

    suspend fun inserUserSubjectCrossRef(list: List<UserSubjectCrossRef>) {
        db.userDao().insertUserSubCrossRef(list)
    }

    suspend fun getUserAndSubjects(): List<UserAndSubjects> {
        return db.userDao().getUserWithSubject()
    }

}