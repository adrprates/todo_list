package com.dm.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.SavedStateViewModelFactory
import com.dm.todolist.navigation.NavGraph
import com.dm.todolist.ui.theme.TodoListTheme
import com.dm.todolist.viewmodel.TaskViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoListTheme {
                val taskViewModel: TaskViewModel = viewModel(
                    factory = SavedStateViewModelFactory(application, this)
                )
                NavGraph(viewModel = taskViewModel)
            }
        }
    }
}