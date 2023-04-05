package com.example.ficha5ex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val textView = findViewById<TextView>(R.id.lista)

        val com = Comunica()
        com.url= "https://apoiodi.estgv.ipv.pt/ws_pdm/?nmec=23905&token=48398252"
        com.co = this

        com.lista_de_concelhos(textView)
    }
}
