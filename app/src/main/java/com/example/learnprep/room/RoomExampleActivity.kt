package com.example.learnprep.room

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.learnprep.room.db.AppDatabase
import com.example.learnprep.room.db.DatabaseProvider
import com.example.learnprep.room.repo.UserRepository
import com.example.learnprep.ui.theme.LearnPrepTheme
import kotlinx.coroutines.launch

class RoomExampleActivity: ComponentActivity() {
    lateinit var db: AppDatabase
    lateinit var repo: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = DatabaseProvider.getDatabase(this)
        repo = UserRepository(db)
        setContent {
            LearnPrepTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainView(
                        modifier = Modifier.padding(innerPadding),
                        dummyInsert = ::dummyInsert

                    )
                }
            }
        }
    }

    private fun dummyInsert() {
        lifecycleScope.launch {
            repo.insertDummyUser()
        }
    }

}

@Preview
@Composable
fun MainView(
    modifier: Modifier = Modifier,
    dummyInsert: ()-> Unit = {}
) {
    Column(modifier = modifier) {
        Button({
            dummyInsert.invoke()
        }) {
            Text(text = "Insert User List")
        }
        Button({}) {
            Text(text = "One to One Relation")
        }
    }
}

