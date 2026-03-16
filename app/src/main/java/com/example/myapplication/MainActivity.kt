package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edtTime = findViewById<EditText>(R.id.edtTime)
        val btnSuggestion = findViewById<Button>(R.id.btnSuggestion)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val tvSuggestion = findViewById<TextView>(R.id.tvSuggestion)

        btnSuggestion.setOnClickListener {
            val time = edtTime.text.toString().trim().lowercase()
            Log.d("Social Spark App", "Time: $time")

            val suggestion = when (time) {
                "morning" -> "send a 'Good Morning' message to a family member."
                "mid-morning" -> "send a 'Thank you' message to a colleague."
                "afternoon" -> "share a funny meme with a friend."
                "snack" -> "send a 'Thinking of you' message."
                "dinner" -> "Call a friend for a 5-minute catch-up."
                "night" -> "Leave a thoughtful comment on a friend's post."
                else -> "Invalid time of day"
            }
            tvSuggestion.text = suggestion
        }

        btnReset.setOnClickListener {
            Log.d("Social Spark App", "Reset button clicked")
            edtTime.text.clear()
            tvSuggestion.text = ""
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}