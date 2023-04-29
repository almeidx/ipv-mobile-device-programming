package com.example.ficha6

import BaseDeDados
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bd = BaseDeDados(this)

        bd.cria_tabelas(bd.writableDatabase)
        bd.ins_pessoa(bd.writableDatabase)
    }

    fun btnCreate(_view: View) {
        val intent = Intent(this, Create::class.java)
        startActivity(intent)
    }

    fun btnRead(_view: View) {
        val intent = Intent(this, Read::class.java)
        startActivity(intent)
    }

    fun btnUpdate(_view: View) {
        val intent = Intent(this, Update::class.java)
        startActivity(intent)
    }

    fun btnDelete(_view: View) {
        val intent = Intent(this, Delete::class.java)
        startActivity(intent)
    }
}
