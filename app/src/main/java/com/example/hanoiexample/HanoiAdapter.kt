package com.example.hanoiexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hanoiexample.databinding.TextItemViewBinding

class HanoiAdapter(val arrayList: ArrayList<String>) : RecyclerView.Adapter<HanoiAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HanoiAdapter.ViewHolder {
        val binding = TextItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class ViewHolder (val binding: TextItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: String){
            binding.hanoiRow.text = data.toString();
        }
    }
}