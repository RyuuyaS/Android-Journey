package com.Poro.listmaker.ui.main

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.Poro.listmaker.models.TaskList

// 1
class MainViewModel(
    private val sharedPreferences: SharedPreferences
) : ViewModel() {
    //2
    lateinit var onListAdded: (() -> Unit)

    //3
    val lists: MutableList<TaskList> by lazy {
        retrieveLists()
    }

    //4
    private fun retrieveLists(): MutableList<TaskList> {
        val sharedPreferencesContent = sharedPreferences.all
        val taskLists = ArrayList<TaskList>()
        for (taskList in sharedPreferencesContent) {
            val itemHashSet = ArrayList(taskList.value as HashSet<String>)
            val list = TaskList(taskList.key, itemHashSet)
            taskLists.add(list)
        }
        return taskLists
    }

    //5
    fun saveList(list: TaskList) {
        sharedPreferences.edit().putStringSet(list.name, list.tasks.toHashSet()).apply()
        lists.add(list)
        onListAdded.invoke()
    }
}