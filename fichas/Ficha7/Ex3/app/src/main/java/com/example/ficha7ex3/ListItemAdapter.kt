package com.example.ficha7ex3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.util.ArrayList

class ListViewAdapter(private val context: Context,
                      private val imageModelArrayList: ArrayList<imagem>) : BaseAdapter() {
    override fun getViewTypeCount(): Int {
        return count
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getCount(): Int {
        return imageModelArrayList.size
    }

    override fun getItem(position: Int): Any {
        return imageModelArrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val holder: ViewHolder
        if (convertView == null) {
            holder = ViewHolder()
            val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.list_view_item, null, true)
            holder.tvname = convertView!!.findViewById(R.id.name) as TextView
            holder.iv = convertView.findViewById(R.id.imgView) as ImageView
            convertView.tag = holder
        } else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = convertView.tag as ViewHolder
        }
        holder.tvname!!.setText(imageModelArrayList[position].da_nomes())
        holder.iv!!.setImageResource(imageModelArrayList[position].da_drawables())
        return convertView
    }

    private inner class ViewHolder {
        var tvname: TextView? = null
        internal var iv: ImageView? = null
    }
}

class imagem {
    var nome_img: String? = null
    var imagem_drawable: Int = 0
    fun da_nomes(): String {
        return nome_img.toString()
    }
    fun atr_nomes(name: String) {
        this.nome_img = name
    }
    fun da_drawables(): Int {
        return imagem_drawable
    }
    fun atr_drawables(image_drawable: Int) {
        this.imagem_drawable = image_drawable
    }
}
