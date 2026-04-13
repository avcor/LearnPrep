package com.example.learnprep.room.repo

import com.example.learnprep.room.db.AppDatabase
import com.example.learnprep.room.entities.User

class UserRepository(private val db: AppDatabase) {

    suspend fun insertDummyUser() {
        val list = mutableListOf<User>()
        for (i in 1..10) {
            list.add(User(userId = i.toLong(), name = "user${i}"))
        }
        db.userDao().insertAllUser(list)
    }
}