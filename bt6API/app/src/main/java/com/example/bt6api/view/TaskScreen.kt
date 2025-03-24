package com.example.bt6api.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.bt6api.data.models.Task
import com.example.bt6api.viewModel.TaskViewModel

@Composable
fun TaskView(viewModel: TaskViewModel = TaskViewModel()){
    val tasks by viewModel.tasks

    if (tasks.isEmpty()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CircularProgressIndicator()
            Text(text = "No tasks available", textAlign = TextAlign.Center)
        }
    } else {
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            items(tasks) {
                TaskCard(it)
            }
        }
    }
}

@Composable
fun TaskCard(task: Task){
    var isChecked = true

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Handle click here */ },
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color.LightGray)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row {
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = {
                        isChecked = !isChecked
                    }
                )
                Column {
                    Text(text = task.title, fontWeight = FontWeight.Bold)
                    Text(text = task.description)
                }
            }
            Row {
                Text(text = "Status: ${task.status}", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.weight(1f))
                Text(text = task.dueDate)
            }
        }
    }
}