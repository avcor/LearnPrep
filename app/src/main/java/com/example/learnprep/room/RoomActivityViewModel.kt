package com.example.learnprep.room

import androidx.compose.runtime.saveable.listSaver
import androidx.compose.ui.layout.SubcomposeSlotReusePolicy
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.learnprep.room.entities.LibraryCard
import com.example.learnprep.room.entities.Marks
import com.example.learnprep.room.entities.Subject
import com.example.learnprep.room.entities.User
import com.example.learnprep.room.entities.UserSubjectCrossRef
import com.example.learnprep.room.repo.RoomRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RoomActivityViewModel(
    private val repo: RoomRepository
) : ViewModel() {

    private val _textList = MutableStateFlow<List<String>>(listOf())
    val textList = _textList.asStateFlow()

    fun dummyInsert() {
        viewModelScope.launch {
            val list = mutableListOf<User>()
            for (i in 1..10) {
                list.add(User(userId = (99 - i).toLong(), name = "user${i}"))
            }
            repo.insertUser(list)
        }
    }

    fun getUserAndCard() {
        viewModelScope.launch {
            val list = repo.getUserAndCard().map { it.toString() }
            _textList.value = list.ifEmpty {
                mutableListOf("Nothing")
            }
        }
    }

    fun dummyInsertLibraryCards() {
        viewModelScope.launch {
            val list = mutableListOf<LibraryCard>()
            for (i in 1..5) {
                list.add(LibraryCard(0, i.toLong()))
            }
            repo.insertLibraryCard(list)
        }
    }

    fun dummyInsertMarks() {
        viewModelScope.launch {
            val list = mutableListOf<Marks>(
                Marks(id = 0, marks = 44, "English", 89),
                Marks(id = 0, marks = 99, "Maths", 90),
                Marks(id = 0, marks = 0, "Game", 91)
            )
            repo.insertMarks(list)
        }
    }

    fun getUserAndMarks() {
        viewModelScope.launch {
            _textList.value = repo.getUserAndMarks().map { it.toString() }.ifEmpty {
                listOf("Nothing One Many")
            }
        }
    }

    fun dummySubjectInsert() {
        viewModelScope.launch {
            val list = mutableListOf(
                Subject(101, "English"),
                Subject(102, "Maths"),
                Subject(103, "Science")
            )
            repo.insertSubjects(list)
            val crossRef = mutableListOf(
                UserSubjectCrossRef(98, 101),
                UserSubjectCrossRef(98, 102),
                UserSubjectCrossRef(98, 103),
                UserSubjectCrossRef(97, 102),
                UserSubjectCrossRef(96, 103)
            )
            repo.inserUserSubjectCrossRef(crossRef)
        }
    }

    fun getUserWithSubject() {
        viewModelScope.launch {
            val list = repo.getUserAndSubjects().map { it.toString() }
            list.ifEmpty {
                mutableListOf("Nothing User and Subject")
            }
            _textList.value = list
        }
    }
}

class ViewModelFactory(private val repo: RoomRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RoomActivityViewModel(repo) as T
    }
}