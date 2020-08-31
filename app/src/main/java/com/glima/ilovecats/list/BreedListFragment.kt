package com.glima.ilovecats.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.glima.ilovecats.BreedVO
import com.glima.ilovecats.databinding.FragmentBreedsListBinding
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.compat.ViewModelCompat.viewModel

class BreedListFragment : Fragment() {

    private val breedListViewModel by viewModel(this, BreedListViewModel::class.java)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentBreedsListBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val adapter = BreedsAdapter { breed: BreedVO? ->
            findNavController().navigate(
                BreedListFragmentDirections.actionBreedsFragmentToBreedDetailFragment(breed!!)
            )
        }

        lifecycleScope.launch {
            breedListViewModel.getBreeds()
        }

        binding.breedsList.adapter = adapter.withLoadStateFooter(
            BreedLoadStateAdapter(adapter::retry)
        )

        breedListViewModel.breeds.observe(viewLifecycleOwner, Observer { pagingData ->
            adapter.submitData(lifecycle, pagingData)
        })

        return binding.root
    }
}