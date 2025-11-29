package com.dm.todolist.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.dm.todolist.model.Task

class TaskViewModel : ViewModel() {
    private var taskIdCounter = 0
    val tasks = mutableStateListOf<Task>()

    fun addTask(title: String, description: String = "") {
        if (title.isNotBlank()) {
            tasks.add(Task(id = taskIdCounter++, title = title, description = description))
        }
    }

    fun removeTask(task: Task) {
        tasks.remove(task)
    }

    fun toggleTaskDone(task: Task) {
        val index = tasks.indexOf(task)
        if (index != -1) {
            tasks[index] = tasks[index].copy(isDone = !task.isDone)
        }
    }

    fun getTaskById(id: Int): Task? = tasks.find { it.id == id }
}