package com.example.ficha6

import BaseDeDados
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class Delete : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)
    }

    fun deletePessoa(_view: View) {
        val bd = BaseDeDados(this)
        val email = findViewById<EditText>(R.id.emailInput).text.toString()

        val pessoa = bd.get_pessoa_by_email(bd.dbr, email)

        val resText = if (pessoa == null) {
            "Utilizador não encontrado"
        } else if (bd.del_pessoa(bd.dbw, pessoa[0].toInt())) {
            "Utilizador apagado"
        } else {
            "Falha ao apagar utilizador"
        }

        Toast.makeText(this, resText, Toast.LENGTH_SHORT).show()
    }
}
