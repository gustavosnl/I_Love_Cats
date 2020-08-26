package com.glima.ilovecats.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.glima.ilovecats.databinding.ItemLoadingStateBinding
import com.glima.ilovecats.list.BreedLoadStateAdapter.LoadStateViewHolder

class BreedLoadStateAdapter(val retry: () -> Unit) : LoadStateAdapter<LoadStateViewHolder>() {
    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        val binding = ItemLoadingStateBinding.inflate(LayoutInflater.from(parent.context))
        return LoadStateViewHolder(binding)
    }

    inner class LoadStateViewHolder(private val binding: ItemLoadingStateBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(loadState: LoadState) {
            binding.loadState = loadState
            binding.executePendingBindings()

            binding.let {
                it.progressBar.isVisible = loadState is LoadState.Loading
                it.textView.isVisible = loadState is LoadState.Error

                it.button.let { button ->
                    button.isVisible = loadState is LoadState.Error
                    button.setOnClickListener { retry.invoke() }
                }
            }
        }
    }

}
