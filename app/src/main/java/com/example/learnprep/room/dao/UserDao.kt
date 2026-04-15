package com.example.learnprep.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.learnprep.room.entities.User
import com.example.learnprep.room.entities.UserAndLibCard
import com.example.learnprep.room.entities.UserAndMarks
import com.example.learnprep.room.entities.UserAndSubjects
import com.example.learnprep.room.entities.UserSubjectCrossRef

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllUser(list: List<User>)

    @Transaction
    @Query("SELECT * FROM  User")
    suspend fun getUserWithCards(): List<UserAndLibCard>

    @Transaction
    @Query("SELECt * FROM User")
    suspend fun getUserWithMarks(): List<UserAndMarks>

    @Transaction
    @Query("SELECT * FROM User")
    suspend fun getUserWithSubject(): List<UserAndSubjects>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserSubCrossRef(list: List<UserSubjectCrossRef>)
}