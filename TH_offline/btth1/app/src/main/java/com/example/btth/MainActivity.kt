package com.example.btth

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var nameInput: EditText
    private lateinit var ageInput: EditText
    private lateinit var checkButton: Button
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Khởi tạo các view
        nameInput = findViewById(R.id.ptName)
        ageInput = findViewById(R.id.ptAge)
        checkButton = findViewById(R.id.btnCheck)
        resultText = TextView(this) // Tạo TextView để hiển thị kết quả

        val layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.topToBottom = R.id.btnCheck
        resultText.layoutParams = layoutParams

        // Thêm TextView vào layout
        findViewById<ConstraintLayout>(R.id.main).addView(resultText)

        // Thiết lập sự kiện cho nút kiểm tra
        checkButton.setOnClickListener {
            val age = ageInput.text.toString().toIntOrNull()
            if (age != null) {
                val resultMessage = when {
                    age > 65 -> "Người già"
                    age in 7..65 -> "Người lớn"
                    age in 3..6 -> "Trẻ em"
                    else -> "Em bé"
                }
                resultText.text = resultMessage
            } else {
                resultText.text = "Vui lòng nhập tuổi hợp lệ."
            }
        }
    }
}