package com.android.churrascometro

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.adapter_compra.view.*

class CompraAdapter(val compras: List<Compra>, val act: Activity): BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val view = act.layoutInflater.inflate(R.layout.adapter_compra, parent, false)
        val compra = compras.get(position)
        var icone = view.iconeImageView
        var titulo = view.tituloTextView
        var quantidade = view.quantidadeTextView

        icone.setImageResource(compra.foto)
        titulo.text = compra.item
        quantidade.text = compra.quantidade

        return view
    }

    override fun getItem(position: Int): Any? {
        return compras.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return compras.size
    }

}
