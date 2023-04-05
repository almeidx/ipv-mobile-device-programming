package com.example.ficha4_ex3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val telefone = findViewById<Button>(R.id.telefone)
        val url = findViewById<Button>(R.id.url)

        telefone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:+351 232 480 700")
            startActivity(intent)
        }

        url.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.ipv.pt/")
            startActivity(intent)
        }
    }
}
