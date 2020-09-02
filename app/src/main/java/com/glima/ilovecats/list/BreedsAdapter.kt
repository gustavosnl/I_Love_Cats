package com.glima.ilovecats.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.glima.ilovecats.BreedVO
import com.glima.ilovecats.databinding.ItemBreedBinding
import com.glima.ilovecats.list.BreedsAdapter.BreedViewHolder

class BreedsAdapter(val onclick: (BreedVO) -> Unit) :
    PagingDataAdapter<BreedVO, BreedViewHolder>(BreedDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedViewHolder {
        return BreedViewHolder(ItemBreedBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: BreedViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class BreedViewHolder(private val binding: ItemBreedBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(breedVO: BreedVO?) {
            breedVO?.let { breed ->
                binding.root.setOnClickListener { onclick.invoke(breed) }
                binding.breed = breed
                binding.executePendingBindings()
            }
        }
    }
}

class BreedDiffUtil : DiffUtil.ItemCallback<BreedVO>() {
    override fun areItemsTheSame(oldItem: BreedVO, newItem: BreedVO): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: BreedVO, newItem: BreedVO): Boolean {
        return oldItem == newItem
    }
}
