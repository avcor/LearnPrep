package com.example.learnprep.room

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.learnprep.room.db.DatabaseProvider
import com.example.learnprep.room.repo.RoomRepository
import com.example.learnprep.ui.theme.LearnPrepTheme

class RoomExampleActivity : ComponentActivity() {
    lateinit var vm: RoomActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repo = RoomRepository(DatabaseProvider.getDatabase(this))
        vm = ViewModelProvider(this, ViewModelFactory(repo))[RoomActivityViewModel::class.java]

        setContent {
            LearnPrepTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainView(
                        modifier = Modifier.padding(innerPadding),
                        vm = vm
                    )
                }
            }
        }
    }

}


@Composable
fun MainView(
    modifier: Modifier = Modifier,
    vm: RoomActivityViewModel,
) {
    val list = vm.textList.collectAsState()

    Column(modifier = modifier) {
        Button({
            vm.dummyInsert()
        }) {
            Text(text = "Insert Dummy User List")
        }
        Button({
            vm.dummyInsertLibraryCards()
        }) {
            Text(text = "Insert Library Cards")
        }
        Button({
            vm.getUserAndCard()
        }) {
            Text(text = "Get UserAndCard One_One Relation")
        }
        Button({
            vm.dummyInsertMarks()
        }) {
            Text(text = "Insert Marks")
        }
        Button({
            vm.getUserAndMarks()
        }) {
            Text(text = "Get UserAndMarks One_Many Relation")
        }
        Button({
            vm.dummySubjectInsert()
        }) {
            Text(text = "Insert User with Subject")
        }
        Button({
            vm.getUserWithSubject()
        }) {
            Text(text = "Get User with subject")
        }
        LazyColumn {
            items(list.value) {
                Text(text = it)
                Spacer(modifier = Modifier.padding(8.dp))
            }
        }
    }
}