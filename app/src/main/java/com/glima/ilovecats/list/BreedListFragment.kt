package com.glima.ilovecats.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.glima.ilovecats.BreedVO
import com.glima.ilovecats.databinding.FragmentBreedsListBinding
import org.koin.android.viewmodel.compat.ViewModelCompat.viewModel

class BreedListFragment : Fragment() {

    private val breedListViewModel by viewModel(this, BreedListViewModel::class.java)
    lateinit var adapter: BreedsAdapter
    lateinit var binding: FragmentBreedsListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBreedsListBinding.inflate(inflater)

        setupBreedsAdapter()
        observeBreedsFromViewModel()

        return binding.root
    }

    private fun setupBreedsAdapter() {
        adapter = BreedsAdapter { breed: BreedVO ->
            navigateToDetailsScreen(breed)
        }
        binding.breedsList.adapter = adapter.withLoadStateFooter(
            BreedLoadStateAdapter(adapter::retry)
        )
    }

    private fun observeBreedsFromViewModel() {
        breedListViewModel.breeds.observe(viewLifecycleOwner, Observer { pagingData ->
            adapter.submitData(lifecycle, pagingData)
        })
    }

    private fun navigateToDetailsScreen(breed: BreedVO) {
        findNavController().navigate(
            BreedListFragmentDirections.actionBreedsFragmentToBreedDetailFragment(breed)
        )
    }
}