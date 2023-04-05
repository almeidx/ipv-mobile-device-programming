package com.example.ficha5ex2

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException

class Comunica {
    lateinit var url: String
    lateinit var co : Context

    @SuppressLint("SetTextI18n")
    fun lista_de_concelhos(textView: TextView) {
        val requestQueue = Volley.newRequestQueue(co)

        val request = JsonObjectRequest(Request.Method.POST, url, null, { response -> try {
            val jsonArray = response.getJSONArray("data")

            textView.text = ""

            Log.i("Array", jsonArray.toString())
            Log.i("Array", jsonArray.length().toString())

            for (i in 0 until jsonArray.length()) {
                val distr = jsonArray.getJSONObject(i)
                Log.i("Concelhos", distr.getString("concelho").toString())

                textView.text = textView.text.toString() + "\n" + distr.getString("concelho").toString()
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        }, { error -> error.printStackTrace() })

        requestQueue.add(request)
    }
}
