package com.example.btth4

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

val baseUrl = "https://amock.io/api/researchUTH/"
val endpoint = "tasks"
val fullUrl = "$baseUrl$endpoint"

interface ApiService {
    @GET("tasks")
    suspend fun getItems(): List<Item>
}

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://amock.io/api/researchUTH/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
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
fun ItemListScreen() {
    val coroutineScope = rememberCoroutineScope()
    val items = remember { mutableStateOf<List<Item>>(emptyList()) }
    val isLoading = remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        isLoading.value = true
        try {
            items.value = RetrofitInstance.api.getItems()
        } catch (e: Exception) {
        } finally {
            isLoading.value = false
        }
    }

    if (isLoading.value) {
        Text("Loading...")
    } else {
        LazyColumn {
            items(items.value) { item ->
                ItemCard(item)
            }
        }
    }
}

@Composable
fun ItemCard(item: Item) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
            .clickable { /* Handle item click */ }
            .padding(16.dp)
    ) {
        Column {
            Text(text = item.title, fontSize = 20.sp, color = Color.Black)
            Text(text = item.description, fontSize = 14.sp, color = Color.Gray)
        }
    }
}