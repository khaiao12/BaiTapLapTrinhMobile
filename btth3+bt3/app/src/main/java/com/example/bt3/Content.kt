package com.example.bt3

import android.text.style.StrikethroughSpan
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
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun ContentScreen(navController: NavController) {
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
        ButtonItem(title = "Text", description = "Displays text", navController)
        ButtonItem(title = "Image", description = "Displays an image", navController)
        SectionTitle(title = "Input")
        ButtonItem(title = "TextField", description = "Input field for text", navController)
        ButtonItem(title = "PasswordField", description = "Input field for passwords", navController)
        SectionTitle(title = "Layout")
        ButtonItem(title = "Column", description = "Arranges elements vertically", navController)
        ButtonItem(title = "Row", description = "Arranges elements horizontally", navController)
        ButtonItem(title = "Box", description = "Box", navController)
    }
}

@Composable
fun ButtonItem(title: String, description: String, navController: NavController) {

        Button(
            onClick = {
                navController.navigate(title)
            },
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

@Composable
fun CustomTopAppBar(navController: NavController, title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { navController.popBackStack() }) {
            Text("<", color = Color.Blue, fontSize = 40.sp)
        }
        Spacer(modifier = Modifier.width(50.dp))
        Text(text = title, color = Color.Blue, fontSize = 40.sp)
    }
}

@Composable
fun TextScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomTopAppBar(navController, title = "Text Detail")
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "The ",
                fontSize = 24.sp,
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = "quick",
                fontSize = 24.sp,
                textDecoration = TextDecoration.LineThrough

            )
            Text(
                text = "Brown",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF8B4513) // Màu nâu
            )
            Text(
                text = "over",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "the",
                fontSize = 24.sp,
                textDecoration = TextDecoration.Underline
            )
            Text(
                text = "lazy",
                fontSize = 24.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "dog.",
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun ImageScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomTopAppBar(navController, title = "Image Detail")
        Text("This is the Image Screen")
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun TextFieldScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomTopAppBar(navController, title = "Text field Detail")
        Text("This is the Text Field Screen")
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun PasswordFieldScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomTopAppBar(navController, title = "Password Field Detail")
        Text("This is the Password Field Screen")
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun ColumnScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomTopAppBar(navController, title = "Column Detail")
        Text("This is the Column Screen")
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun RowScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomTopAppBar(navController, title = "Row Detail")
        Text("This is the Row Screen")
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun BoxScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomTopAppBar(navController, title = "Box Detail")
        Text("This is the Box Screen")
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun previewTopBar(){
    val navController = rememberNavController()
    CustomTopAppBar(navController, title = "TEST")
}

