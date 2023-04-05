package com.example.ficha4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val input1 = intent.getStringExtra("input1")?.toInt() ?: 0
        val input2 = intent.getStringExtra("input2")?.toInt() ?: 0
        val input3 = intent.getStringExtra("input3")?.toInt() ?: 0

        val textView = findViewById<TextView>(R.id.textView)

        val smallestNumber = Math.min(input1, Math.min(input2, input3))

        textView.text = smallestNumber.toString()
    }
}
