package com.example.bt4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.bt4.ui.theme.Bt4Theme
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val isSplashVisible = remember { mutableStateOf(true) }
            val navController = rememberNavController()

            if (isSplashVisible.value) {
                SplashScreen {
                    isSplashVisible.value = false
                }
            } else {
                NavHost(navController = navController, startDestination = "first"){
                    composable("first"){ MainContent(0,navController)}
                    composable("second"){ SecondContent(1,navController)}
                    composable("third"){ ThirdContent(1,navController)}
                    composable("last"){ LastContent()}
                }
            }
        }
    }
}
