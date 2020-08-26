package com.glima.ilovecats.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.glima.domain.business.model.Breed
import com.glima.ilovecats.databinding.ItemBreedBinding
import com.glima.ilovecats.list.BreedsAdapter.BreedViewHolder


class BreedsAdapter(val onclick: (Breed?) -> Unit) :
    PagingDataAdapter<Breed, BreedViewHolder>(BreedDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedViewHolder {
        return BreedViewHolder(ItemBreedBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: BreedViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class BreedViewHolder(private val binding: ItemBreedBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        fun bind(breed: Breed?) {
            binding.root.setOnClickListener(this)
            binding.breed = breed
            binding.executePendingBindings()
        }

        override fun onClick(p0: View?) {
            onclick.invoke(getItem(bindingAdapterPosition))
        }
    }

}

class BreedDiffUtil : DiffUtil.ItemCallback<Breed>() {
    override fun areItemsTheSame(oldItem: Breed, newItem: Breed): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Breed, newItem: Breed): Boolean {
        return oldItem == newItem
    }

}