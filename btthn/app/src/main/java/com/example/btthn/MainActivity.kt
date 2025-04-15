package com.example.btthn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import com.example.btthn.ui.theme.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {

    private lateinit var themeDataStore: ThemeDataStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        themeDataStore = ThemeDataStore(this)

        setContent {
            ThemeSwitcherApp(themeDataStore)
        }
    }
}

@Composable
fun ThemeSwitcherApp(themeDataStore: ThemeDataStore) {
    var themeColor by remember { mutableStateOf(Color.White) }
    var selectedTheme by remember { mutableStateOf("white") } // Biến tạm thời để lưu theme được chọn
    val coroutineScope = rememberCoroutineScope()

    // Lấy giá trị theme từ DataStore
    LaunchedEffect(Unit) {
        themeDataStore.theme.collect { theme ->
            themeColor = when (theme) {
                "black" -> Color.Black
                "blue" -> Color.Blue
                else -> Color.White
            }
        }
    }

    // Thay đổi màu nền dựa trên màu đã chọn
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(themeColor),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                Button(onClick = {
                    selectedTheme = "white"
                    themeColor = Color.White // Cập nhật màu để hiển thị
                }) {
                    Text("Trắng")
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(onClick = {
                    selectedTheme = "black"
                    themeColor = Color.Black // Cập nhật màu để hiển thị
                }) {
                    Text("Đen")
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(onClick = {
                    selectedTheme = "cyan"
                    themeColor = Color.Cyan // Cập nhật màu để hiển thị
                }) {
                    Text("Xanh")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                // Gọi saveTheme trong một coroutine khi nhấn nút Apply
                coroutineScope.launch {
                    themeDataStore.saveTheme(selectedTheme)
                }
            }) {
                Text("Áp Dụng")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    // Sử dụng LocalContext để tạo ThemeDataStore
    val context = LocalContext.current
    ThemeSwitcherApp(ThemeDataStore(context))
}