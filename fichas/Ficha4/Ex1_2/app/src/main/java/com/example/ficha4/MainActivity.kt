package com.example.ficha4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 = findViewById<Button>(R.id.button)
        val btn2 = findViewById<Button>(R.id.button2)

        btn1.setOnClickListener {
            openActivity(Intent(this, Activity2::class.java))
        }

        btn2.setOnClickListener {
            openActivity(Intent(this, Activity3::class.java))
        }
    }

    private fun openActivity(intent: Intent) {
        val input1 = findViewById<EditText>(R.id.editTextNumber)
        val input2 = findViewById<EditText>(R.id.editTextNumber2)
        val input3 = findViewById<EditText>(R.id.editTextNumber3)

        intent.putExtra("input1", input1.text.toString())
        intent.putExtra("input2", input2.text.toString())
        intent.putExtra("input3", input3.text.toString())

        startActivity(intent)
    }
}
