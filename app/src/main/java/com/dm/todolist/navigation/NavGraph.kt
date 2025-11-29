package com.dm.todolist.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dm.todolist.view.TaskDetailScreen
import com.dm.todolist.view.TaskListScreen
import com.dm.todolist.viewmodel.TaskViewModel

@Composable
fun NavGraph(viewModel: TaskViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "list") {
        composable("list") {
            TaskListScreen(viewModel, navController)
        }
        composable(
            "detail/{taskId}",
            arguments = listOf(navArgument("taskId") { type = NavType.IntType })
        ) { backStackEntry ->
            val taskId = backStackEntry.arguments?.getInt("taskId") ?: -1
            TaskDetailScreen(taskId, viewModel, navController)
        }
    }
}