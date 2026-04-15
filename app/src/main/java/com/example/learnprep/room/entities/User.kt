package com.example.learnprep.room.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity
data class User (
    @PrimaryKey(autoGenerate = true)
    val userId: Long,
    val name: String
)

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["userId"],
            childColumns = ["userOwnerId"]
        )
    ]
)
data class Marks(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val marks: Int,
    val subject: String,
    val userOwnerId: Long,
)

@Entity
data class Subject(
    @PrimaryKey(autoGenerate = true)
    val subjectId: Long,
    val subjectName: String,
)

@Entity(primaryKeys = ["userId", "subjectId"])
data class UserSubjectCrossRef(
    val userId: Long,
    val subjectId: Long
)

@Entity(
    indices = [Index("userOwnerId", unique = true)]
)
data class LibraryCard(
    @PrimaryKey(autoGenerate = true)
    val cardId: Long,
    val userOwnerId: Long
)
