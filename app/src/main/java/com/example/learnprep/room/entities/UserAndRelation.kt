package com.example.learnprep.room.entities

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class UserAndLibCard(
    /* this is one-to-one relationship*/
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "userOwnerId",
    ) val libraryCard: LibraryCard?
)

data class UserAndMarks(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "userOwnerId"
    ) val marks: List<Marks>
)

data class UserAndSubjects(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "subjectId",
        associateBy = Junction(UserSubjectCrossRef::class)
    ) val subject: List<Subject>
)