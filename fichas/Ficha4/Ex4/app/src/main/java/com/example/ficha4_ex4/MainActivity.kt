package com.example.ficha4_ex4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nome = findViewById<EditText>(R.id.nome)
        val phone = findViewById<EditText>(R.id.phone)
        val email = findViewById<EditText>(R.id.email)

        val registarBtn = findViewById<Button>(R.id.registar)

        registarBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_INSERT)
            intent.type = ContactsContract.Contacts.CONTENT_TYPE
            intent.putExtra("name", nome.text.toString())
            intent.putExtra("phone", phone.text.toString())
            intent.putExtra("email", email.text.toString())
            startActivity(intent)
        }
    }
}
