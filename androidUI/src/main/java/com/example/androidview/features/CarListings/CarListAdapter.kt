package com.example.androidview.features.CarListings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidview.databinding.ItemCarBinding
import entities.CarMake

class CarListAdapter : ListAdapter<CarMake, CarListAdapter.CarViewHolder>(ItemComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val binding = ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
       val current = getItem(position)
        current?.let {
            holder.bind(current)
        }
    }

    class CarViewHolder(private val binding: ItemCarBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(car: CarMake){
            binding.apply {
                carmake.text = car.Make_Name
                carmodel.text = car.Mfr_Name
            }
        }
    }

    class ItemComparator : DiffUtil.ItemCallback<CarMake>() {
        override fun areItemsTheSame(oldItem: CarMake, newItem: CarMake) = oldItem.Make_ID == newItem.Make_ID
        override fun areContentsTheSame(oldItem: CarMake, newItem: CarMake) = oldItem == newItem
    }
}