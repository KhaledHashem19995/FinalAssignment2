package com.example.finalassignment2.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@kotlinx.parcelize.Parcelize
@Entity(tableName = "task_table")
class TaskEntry (
    @PrimaryKey(autoGenerate = true)
    var  id : Int,
    var title: String,
    var category: String,
    var description: String,
    var date: String
    ):Parcelable