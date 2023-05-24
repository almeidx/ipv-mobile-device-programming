package com.example.ficha7ex3

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView

class MainFragment : Fragment() {
    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val view_ = requireView()
        val listView = view_.findViewById<ListView>(R.id.listView)

        val imageModelArrayList = ArrayList<imagem>()

        imageModelArrayList.add(makeImg("backhand", R.drawable.ic_backhand_foreground))
        imageModelArrayList.add(makeImg("fronthand", R.drawable.ic_fronthand_foreground))
        imageModelArrayList.add(makeImg("wavinghand", R.drawable.ic_wavinghand_foreground))

        listView.adapter = ListViewAdapter(requireContext(), imageModelArrayList)

        listView.setOnItemClickListener { _, _, i, _ ->
            val img = imageModelArrayList[i]

            val bundle = Bundle()
            bundle.putString("nome", img.da_nomes())
            bundle.putInt("drawable", img.da_drawables())

            val largeFragment = LargeFragment()
            largeFragment.arguments = bundle

            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, largeFragment)
                .addToBackStack(null)
                .commit()
        }
    }

    private fun makeImg(nome: String, drawable: Int): imagem {
        val img = imagem()
        img.atr_nomes(nome)
        img.atr_drawables(drawable)
        return img
    }
}
