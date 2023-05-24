package com.example.ficha7ex1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class LargeView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_large_view)

        val nome = intent.getStringExtra("nome")
        val drawable = intent.getIntExtra("drawable", 0)

        val imgView = findViewById<ImageView>(R.id.imageView)
        val textView = findViewById<TextView>(R.id.textView)

        imgView.setImageResource(drawable)
        textView.text = nome
    }
}
