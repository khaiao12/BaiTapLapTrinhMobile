package com.example.bt1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Tạo và cấu hình profile image
        val profileImage = findViewById<ImageView>(R.id.profile_image)
        profileImage.setImageResource(R.drawable.profile_image)

        // Tạo và cấu hình tên người dùng
        val nameTextView = findViewById<TextView>(R.id.name_text_view)
        nameTextView.text = "Johan Smith"

        // Tạo và cấu hình vị trí
        val locationTextView = findViewById<TextView>(R.id.location_text_view)
        locationTextView.text = "California, USA"
    }
}