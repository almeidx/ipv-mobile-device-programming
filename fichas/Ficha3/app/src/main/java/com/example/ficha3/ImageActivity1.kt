package com.example.ficha3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ImageActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image1)

        val image = intent.getIntExtra("image", 0)

        val imageView = findViewById<ImageView>(R.id.imageView3)
        imageView.setImageResource(image)
    }
}
