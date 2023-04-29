package com.example.ficha6

import BaseDeDados
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class Read : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read)

        val lista = findViewById<ListView>(R.id.lista)

        val bd = BaseDeDados(this)
        val pessoasList = bd.todos_pessoas(bd.dbr)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pessoasList)
        lista.adapter = adapter
    }
}
