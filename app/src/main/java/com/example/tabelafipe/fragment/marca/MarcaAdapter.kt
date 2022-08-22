package com.example.tabelafipe.fragment.marca

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.tabelafipe.R
import com.example.tabelafipe.model.marca.ArrayMarcas
import kotlinx.android.synthetic.main.card_brands.view.*

class MarcaAdapter : RecyclerView.Adapter<MarcaAdapter.MyViewHolder>() {

    private var myList = emptyList<ArrayMarcas>()

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_brands, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = myList[position]

        holder.itemView.brands_tv.text = currentItem.nome
        holder.itemView.id_brand_tv.text = currentItem.codigo.toString()

        holder.itemView.cardBrands.setOnClickListener {
            val action = MarcaFragmentDirections.actionMarcaFragmentToModeloFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    fun setData(newList: List<ArrayMarcas>) {
        myList = newList
        notifyDataSetChanged()
    }
}