package com.example.my1stapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var checkButton: Button
    private lateinit var resultText: TextView
    private lateinit var resultText2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Khởi tạo các thành phần giao diện
        checkButton = findViewById(R.id.btnHello)
        resultText = findViewById(R.id.txtResult)
        resultText2 = findViewById(R.id.txtResult2)


        // Thiết lập sự kiện nhấn nút
        checkButton.setOnClickListener {
            resultText.text = "I'm"
            resultText2.text = "Nguyễn Văn A"
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
