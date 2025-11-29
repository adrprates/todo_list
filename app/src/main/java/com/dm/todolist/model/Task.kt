package com.dm.todolist.model

data class Task(
    val id: Int,
    val title: String,
    var isDone: Boolean = false,
    val description: String = ""
)