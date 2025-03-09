package com.example.baitap2

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.baitap2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val library = Library()
    private lateinit var linearLayoutBooks: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        // Cấu hình ActionBar với NavController
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // Khởi tạo LinearLayout để hiển thị danh sách sách
        linearLayoutBooks = findViewById(R.id.linearLayoutBooks)

        // Thêm sách mẫu
        library.addBook(Book(1, "1984", "George Orwell"))
        library.addBook(Book(2, "To Kill a Mockingbird", "Harper Lee"))

        // Hiển thị danh sách sách
        displayBooks()
    }

    private fun displayBooks() {
        linearLayoutBooks.removeAllViews() // Xóa các mục cũ trước khi thêm

        for (book in library.showBooks()) {
            // Tạo view cho mỗi sách
            val bookView = LayoutInflater.from(this).inflate(R.layout.item_book, linearLayoutBooks, false)

            // Thiết lập thông tin cho view
            val titleTextView = bookView.findViewById<TextView>(R.id.textViewTitle)
            val authorTextView = bookView.findViewById<TextView>(R.id.textViewAuthor)

            titleTextView.text = book.title
            authorTextView.text = book.author

            // Thêm view vào LinearLayout
            linearLayoutBooks.addView(bookView)
        }
    }
}
