package com.example.bt5

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.*

@Composable
fun DetailScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTopBar("Detail",navController)
        Text(text = "This is the detail content.", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Here you can add more information about the item.", style = MaterialTheme.typography.bodyMedium)

        Spacer(Modifier.height(200.dp))
        Button(onClick = { navController.navigate("home") }) {
            Text("Back to Root")
        }
    }
}