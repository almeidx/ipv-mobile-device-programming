package com.example.ficha6

import BaseDeDados
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Update : AppCompatActivity() {
    private var nome: String = ""
    private var email: String = ""
    private var id: Int = -1
    private var bd: BaseDeDados? = null

    private var novoNome: EditText? = null
    private var novoEmail: EditText? = null
    private var saveBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        novoNome = findViewById<EditText>(R.id.editNome)
        novoEmail = findViewById<EditText>(R.id.editEmail)
        saveBtn = findViewById<Button>(R.id.saveBtn)

        bd = BaseDeDados(this)
    }

    fun procurarBtn(_view: View) {
        val findEmail = findViewById<EditText>(R.id.findEmail).text.toString()
        val pessoa = bd!!.get_pessoa_by_email(bd!!.dbr, findEmail)

        Log.i("Pessoa", pessoa.toString())

        if (pessoa == null) {
            novoNome!!.setText("")
            novoEmail!!.setText("")
            return;
        }

        id = pessoa[0].toInt()
        nome = pessoa[1]
        email = pessoa[2]

        novoNome!!.setText(nome)
        novoEmail!!.setText(email)

        toggleVisibility(true)
    }

    fun guardarBtn(_view: View) {
        val novoNome_ = novoNome!!.text.toString()
        val novoEmail_ = novoEmail!!.text.toString()

        if (novoNome_ != nome || novoEmail_ != email) {
            bd!!.update_pessoa(bd!!.dbw, id, novoNome_, novoEmail_)

            Toast.makeText(this, "Pessoa atualizada com sucesso!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Nada foi alterado!", Toast.LENGTH_SHORT).show()
        }

        toggleVisibility(false)
    }

    private fun toggleVisibility(visible: Boolean) {
        val visibility = if (visible) View.VISIBLE else View.INVISIBLE
        novoNome!!.visibility = visibility
        novoEmail!!.visibility = visibility
        saveBtn!!.visibility = visibility
    }
}
