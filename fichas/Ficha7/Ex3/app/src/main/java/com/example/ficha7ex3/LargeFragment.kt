package com.example.ficha7ex3

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class LargeFragment : Fragment() {
    companion object {
        fun newInstance() = LargeFragment()
    }

    private lateinit var viewModel: LargeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_large, container, false)

        val args = requireArguments()
        val nome = args.getString("nome")
        val drawable = args.getInt("drawable")

        if (nome != null) {
            val nomeTextView = view.findViewById<TextView>(R.id.textView)
            nomeTextView.text = nome

            val drawableImageView = view.findViewById<ImageView>(R.id.imageView)
            drawableImageView.setImageResource(drawable)
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[LargeViewModel::class.java]
    }
}
