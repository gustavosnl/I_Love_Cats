package com.glima.ilovecats.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.glima.domain.business.model.BreedImage
import com.glima.domain.business.usecase.LoadRandomImageForBreedingUseCase
import com.glima.ilovecats.BreedVO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class BreedDetailViewModel(
    private val loadRandomImageUseCase: LoadRandomImageForBreedingUseCase,
    val breedVO: BreedVO
) : ViewModel() {

    private val _image = MutableLiveData<BreedImage>()
    val image: LiveData<BreedImage>
        get() = _image


    fun loadImage() {
        viewModelScope.launch(Dispatchers.Main) {
            val result = loadRandomImageUseCase.execute(breedVO.id)
            result.collectLatest {
                _image.value = it
            }
        }
    }
}