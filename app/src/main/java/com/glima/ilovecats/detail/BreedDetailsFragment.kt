package com.glima.ilovecats.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.glima.ilovecats.databinding.FragmentBreedDetailBinding
import org.koin.android.viewmodel.compat.ViewModelCompat.viewModel
import org.koin.core.parameter.parametersOf

class BreedDetailsFragment : Fragment() {

    private val breedDetailViewModel by viewModel(this, BreedDetailViewModel::class.java) {
        parametersOf(
            BreedDetailsFragmentArgs.fromBundle(requireArguments())
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentBreedDetailBinding.inflate(inflater)
        breedDetailViewModel.loadImage()

        breedDetailViewModel.image.observe(
            viewLifecycleOwner, Observer {
                Glide.with(requireContext())
                    .load(it.url)
                    .into(binding.catImageView)
            }
        )
        binding.loadRandomImageButton.setOnClickListener {
            breedDetailViewModel.loadImage()
        }

        binding.viewModel = breedDetailViewModel
        return binding.root
    }
}