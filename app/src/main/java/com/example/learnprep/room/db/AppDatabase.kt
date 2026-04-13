package com.example.learnprep.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.learnprep.room.dao.UserDao
import com.example.learnprep.room.entities.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao

}