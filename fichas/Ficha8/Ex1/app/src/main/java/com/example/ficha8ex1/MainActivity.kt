package com.example.ficha8ex1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openMap(_view: View) {
        val latitude = findViewById<EditText>(R.id.latitude)
        val longitude = findViewById<EditText>(R.id.longitude)

        val lat = latitude.text.toString().toDouble()
        val long = longitude.text.toString().toDouble()

        val intent = Intent(this, MapsActivity::class.java)

        intent.putExtra("latitude", lat)
        intent.putExtra("longitude", long)

        startActivity(intent)
    }
}
