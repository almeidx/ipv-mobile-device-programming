package com.example.ficha4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

        val input1 = intent.getStringExtra("input1")?.toInt() ?: 0
        val input2 = intent.getStringExtra("input2")?.toInt() ?: 0
        val input3 = intent.getStringExtra("input3")?.toInt() ?: 0

        val textView4 = findViewById<TextView>(R.id.textView4)

        val biggestNumber = Math.max(input1, Math.max(input2, input3))

        textView4.text = biggestNumber.toString()
    }
}
