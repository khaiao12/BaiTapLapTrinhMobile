package com.example.btlogin.View

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.btlogin.R

@Composable
fun HomeScreen(onSignInClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(80.dp))
            Image(
                painter = painterResource(id = R.drawable.uthlogo),
                contentDescription = "UTH Logo",
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "SmartTasks",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "A simple and efficient to-do app",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Blue
                )
            )
            Spacer(Modifier.height(100.dp))
            Text(
                text = "Welcome",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Ready to explore? Log in to get started",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = { onSignInClick() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "Google Logo",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "SIGN IN WITH GOOGLE")
            }

            Spacer(modifier = Modifier.height(240.dp))
            Text(
                text = "@ UTHSmartTask",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    HomeScreen(onSignInClick = {})
}