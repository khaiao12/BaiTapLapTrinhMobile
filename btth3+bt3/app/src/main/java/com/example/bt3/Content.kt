package com.example.bt3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.ButtonDefaults

@Composable
fun ContentScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "UI Components List",
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .padding(16.dp),
            color = Color.Blue
        )

        SectionTitle(title = "Display")
        ButtonItem(title = "Text", description = "Displays text")
        ButtonItem(title = "Image", description = "Displays an image")
        SectionTitle(title = "Input")
        ButtonItem(title = "TextField", description = "Input field for text")
        ButtonItem(title = "PasswordField", description = "Input field for passwords")
        SectionTitle(title = "Layout")
        ButtonItem(title = "Column", description = "Arranges elements vertically")
        ButtonItem(title = "Row", description = "Arranges elements horizontally")
    }
}

@Composable
fun ButtonItem(title: String, description: String) {

        Button(
            onClick = { /* TODO: Handle button click */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start
            ){
                Text(text = title, fontSize = 20.sp, color = Color.White)
                Text(text = description, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(start = 16.dp))
            }

        }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        fontSize = 20.sp,
        modifier = Modifier.padding(vertical = 8.dp),
        color = Color.Black
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewContentScreen() {
    ContentScreen()
}