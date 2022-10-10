package com.example.bitfittwo


import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.bitfittwo.databinding.Fragment2Binding


class WaterItemViewHolder(
    private val context: Context,
    private val binding: Fragment2Binding
): RecyclerView.ViewHolder(binding.root){

    fun bindWaterItem(waterItem: WaterItem){
        binding.date.text = waterItem.date
        binding.water.text = waterItem.gallons
    }

}