package com.example.finalassignment2.repository

import androidx.lifecycle.LiveData
import com.example.finalassignment2.database.TaskDao
import com.example.finalassignment2.database.TaskEntry

class TaskRepository(val taskDao: TaskDao) {

    suspend fun insert(taskEntry: TaskEntry) = taskDao.insert(taskEntry)

    suspend fun updateData(taskEntry: TaskEntry) = taskDao.update(taskEntry)

    suspend fun deleteData(taskEntry: TaskEntry) = taskDao.delete(taskEntry)

    suspend fun deleteAll(){
        taskDao.deleteAll()
    }

     fun getAllTasks() : LiveData<List<TaskEntry>> = taskDao.getAllTasks()

}