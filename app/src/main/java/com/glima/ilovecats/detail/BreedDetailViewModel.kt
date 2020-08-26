package com.glima.ilovecats.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.glima.domain.business.model.BreedImage
import com.glima.domain.business.usecase.LoadRandomImageForBreedingUseCase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class BreedDetailViewModel(
    private val loadRandomImageUseCase: LoadRandomImageForBreedingUseCase,
    private val args: BreedDetailsFragmentArgs
) : ViewModel() {

    val image = MutableLiveData<BreedImage>()
    val breedVO = args.breed

    fun loadImage() {
        viewModelScope.launch {
            val result = loadRandomImageUseCase.execute(breedVO.id)
            result.collectLatest {
                image.value = it
            }
        }
    }
}