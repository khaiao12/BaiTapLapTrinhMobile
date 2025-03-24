package com.example.bt6api.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bt6api.data.api.RetrofitInstance
import com.example.bt6api.data.models.Task
import kotlinx.coroutines.launch

class TaskViewModel:ViewModel() {
    private val _tasks= mutableStateOf<List<Task>>(emptyList())
    val tasks: State<List<Task>> = _tasks

    private val _error = mutableStateOf<String?>(null)
    val error: State<String?> = _error

    init {
        fetchTask()
    }

    private fun fetchTask(){
        viewModelScope.launch {
            try {
                _tasks.value = RetrofitInstance.api.getTasks()
                _error.value = null
            }catch (e: Exception){
                _error.value = e.message
                //Handle error
            }
        }
    }
}