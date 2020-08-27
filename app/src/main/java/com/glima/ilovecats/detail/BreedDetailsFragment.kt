package com.glima.ilovecats.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.glima.ilovecats.R
import com.glima.ilovecats.databinding.FragmentBreedDetailBinding
import org.koin.android.viewmodel.compat.ViewModelCompat.viewModel
import org.koin.core.parameter.parametersOf

class BreedDetailsFragment : Fragment() {

    private val arguments by lazy { BreedDetailsFragmentArgs.fromBundle(requireArguments()) }
    private val breedDetailViewModel by viewModel(this, BreedDetailViewModel::class.java) {
        parametersOf(arguments.breed)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentBreedDetailBinding.inflate(inflater)
        breedDetailViewModel
        breedDetailViewModel.loadImage()

        breedDetailViewModel.image.observe(
            viewLifecycleOwner, Observer {
                Glide.with(requireContext())
                    .load(it.url)
                    .apply(
                        RequestOptions()
                            .error(R.drawable.ic_img_error_placeholder)
                    ).into(binding.catImageView)
            }
        )
        binding.loadRandomImageButton.setOnClickListener {
            breedDetailViewModel.loadImage()
        }

        binding.viewModel = breedDetailViewModel
        return binding.root
    }
}