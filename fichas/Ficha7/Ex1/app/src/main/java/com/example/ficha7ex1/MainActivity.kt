package com.example.ficha7ex1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)

        val imageModelArrayList = ArrayList<imagem>()

        imageModelArrayList.add(makeImg("backhand", R.drawable.ic_backhand_foreground))
        imageModelArrayList.add(makeImg("fronthand", R.drawable.ic_fronthand_foreground))
        imageModelArrayList.add(makeImg("wavinghand", R.drawable.ic_wavinghand_foreground))

        listView.adapter = ListViewAdapter(this, imageModelArrayList)

        listView.setOnItemClickListener { _, _, i, _ ->
            val img = imageModelArrayList[i]
            val intent = Intent(this, LargeView::class.java)

            intent.putExtra("nome", img.da_nomes())
            intent.putExtra("drawable", img.da_drawables())

            startActivity(intent)
        }
    }

    private fun makeImg(nome: String, drawable: Int): imagem {
        val img = imagem()
        img.atr_nomes(nome)
        img.atr_drawables(drawable)
        return img
    }
}
