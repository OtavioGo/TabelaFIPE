package com.example.tabelafipe.fragment.modelo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tabelafipe.R
import com.example.tabelafipe.model.modelo.ArrayModelos
import com.example.tabelafipe.model.modelo.Modelo
import kotlinx.android.synthetic.main.card_models.view.*

class ModeloAdapter: RecyclerView.Adapter<ModeloAdapter.MyViewHolder>() {

    private var myList = emptyList<Modelo>()

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_models, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = myList[position]

        holder.itemView.models_tv.text = currentItem
        holder.itemView.id_model_tv.text = currentItem.codigo
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    fun setData(newList: List<ArrayModelos>) {
        myList = newList
        notifyDataSetChanged()
    }
}