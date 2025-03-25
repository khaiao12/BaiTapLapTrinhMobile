package com.example.bt6api.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bt6api.R
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
        Column {
            TopBar()
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(8.dp)
            ) {
                items(tasks) {
                    TaskCard(it)
                }
            }
            BottomBar()
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
                    Text(text = "Post #${task.id}", fontWeight = FontWeight.Bold)
                    Text(text = task.title, fontWeight = FontWeight.Bold)
                    Text(text = task.body)
                }
            }
        }
    }
}

@Composable
fun TopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier.size(40.dp)
            )
            Column {
                Text(
                    text = "SmartTasks",
                    color = Color.Cyan,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = "a simple and effecient to-do app",
                    color = Color.Cyan
                )
            }

            Image(
                painter = painterResource(id = R.drawable.bell),
                contentDescription = "Search",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun BottomBar(){
}

@Preview(showBackground = true)
@Composable
fun taskScreenReview(){
    BottomBar()
}
