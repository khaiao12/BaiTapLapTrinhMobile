package com.example.bt1

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Tạo và cấu hình profile image
        val profileImage = findViewById<ImageView>(R.id.profile_image)
        profileImage.setImageResource(R.drawable.ic_launcher_background)

        // Tạo và cấu hình tên người dùng
        val nameTextView = findViewById<TextView>(R.id.name_text_view)
        nameTextView.text = "Johan Smith"

        // Tạo và cấu hình vị trí
        val locationTextView = findViewById<TextView>(R.id.location_text_view)
        locationTextView.text = "California, USA"
    }
}
