package com.example.bitfittwo


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bitfittwo.databinding.Fragment2Binding



class WaterItemAdapter
    (private val waterItems: List<WaterItem>):RecyclerView.Adapter<WaterItemViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WaterItemViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = Fragment2Binding.inflate(from, parent, false)
        return WaterItemViewHolder(parent.context, binding)

    }

    override fun onBindViewHolder(holder: WaterItemViewHolder, position: Int) {
        holder.bindWaterItem(waterItems [position])
    }

    override fun getItemCount(): Int = waterItems.size
}
