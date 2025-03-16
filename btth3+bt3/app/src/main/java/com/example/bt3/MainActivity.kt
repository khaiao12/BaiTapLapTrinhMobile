package com.example.bt3
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bt3.ContentScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "home") {
                composable("home") { AppContent(navController) }
                composable("content") { ContentScreen(navController) }
                composable("Text") { TextScreen(navController) }
                composable("Image") { ImageScreen(navController) }
                composable("TextField") { TextFieldScreen(navController)}
                composable("PasswordField") { PasswordFieldScreen(navController)}
                composable("Column") { ColumnScreen(navController)}
                composable("Row") { RowScreen(navController)}
                composable("Box") { BoxScreen(navController)}
            }
        }
    }
}