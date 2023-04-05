package com.example.ficha3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttons = arrayOf(
            Pair(findViewById<Button>(R.id.button), R.mipmap.lenna2_foreground),
            Pair(findViewById<Button>(R.id.button2), R.mipmap.ic_launcher)
        )

        for (btn in buttons) {
            val (button, image) = btn

            button.setOnClickListener {
                openImageActivity(image)
            }
        }
    }

    private fun openImageActivity(img: Int) {
        val intent = Intent(this, ImageActivity1::class.java)
        intent.putExtra("image", img)
        startActivity(intent)
    }
}
