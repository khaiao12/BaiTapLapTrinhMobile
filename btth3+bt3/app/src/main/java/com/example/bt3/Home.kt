package com.example.bt3
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bt3.R
import androidx.navigation.compose.rememberNavController

@Composable
fun AppContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.jetcom),
            contentDescription = "Logo",
            modifier = Modifier.size(300.dp)
        )

        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "Jetpack Compose",
            fontSize = 24.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            textAlign = TextAlign.Center,
            text = "Jetpack Compose is a modern UI toolkit for building native Android applications using a declarative programming approach.",
            fontSize = 20.sp,
            color = Color.Gray,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(260.dp))

        Button(onClick = { navController.navigate("content") },
            modifier = Modifier.size(300.dp, 50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text(text = "I’m ready", fontSize = 20.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAppContent() {
    val navController = rememberNavController() // Tạo NavController giả
    AppContent(navController)
}