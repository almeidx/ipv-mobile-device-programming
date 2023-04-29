package com.example.ficha6

import BaseDeDados
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class Create : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar)
    }

    fun create(_view: View) {
        val bd = BaseDeDados(this)
        val nome = findViewById<EditText>(R.id.nome).text.toString()
        val email = findViewById<EditText>(R.id.email).text.toString()

        bd.ins_pessoa_lg(bd.dbw, nome, email)

        Toast.makeText(this, "Pessoa criada com sucesso", Toast.LENGTH_SHORT).show()
    }
}
