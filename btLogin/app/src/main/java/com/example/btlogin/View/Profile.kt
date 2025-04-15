package com.example.btlogin.View

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.btlogin.R

@Composable
fun ProfileScreen(
    name: String,
    email: String,
    dateOfBirth: String,
    onBackClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            // Ảnh đại diện
            Image(
                painter = painterResource(id = R.drawable.placeholder), // Thay bằng ảnh đại diện thực tế
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Blue, CircleShape)
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Tên
            TextField(
                value = name,
                onValueChange = {},
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth(),
                enabled = false
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Email
            TextField(
                value = email,
                onValueChange = {},
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth(),
                enabled = false
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Ngày sinh
            TextField(
                value = dateOfBirth,
                onValueChange = {},
                label = { Text("Date of Birth") },
                modifier = Modifier.fillMaxWidth(),
                enabled = false
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Nút quay lại
            Button(
                onClick = { onBackClick() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Back")
            }
        }
    }
}
