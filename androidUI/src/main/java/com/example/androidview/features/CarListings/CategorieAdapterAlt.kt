package com.example.androidview.features.CarListings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidview.databinding.ItemCtgBinding
import entities.Categorie
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class CategorieAdapterAlt :
    ListAdapter<Categorie, CategorieAdapterAlt.CategorieViewHolder>(CtgComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategorieViewHolder {
        val binding = ItemCtgBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategorieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategorieViewHolder, position: Int) {
        val current = getItem(position)
        current?.let {
            holder.bind(current)
        }
    }

    class CategorieViewHolder(private val binding: ItemCtgBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(ctg: Categorie) {
            // binding.item.text = ctg.c_name
            binding.item.setOnClickListener {
                Observable.create<Unit> {
                    CarListingViewModel.call(ctg.c_name)!!
                }
                    .subscribeOn(Schedulers.single())
                    ?.subscribe()
            }
        }
    }

    class CtgComparator : DiffUtil.ItemCallback<Categorie>() {
        override fun areItemsTheSame(oldItem: Categorie, newItem: Categorie) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Categorie, newItem: Categorie) = oldItem == newItem

    }
}