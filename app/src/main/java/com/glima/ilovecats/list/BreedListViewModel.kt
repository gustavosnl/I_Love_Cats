package com.glima.ilovecats.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.glima.domain.business.model.Breed
import com.glima.domain.business.usecase.FetchBreedsUseCase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class BreedListViewModel(private val listBreedsUseCase: FetchBreedsUseCase) : ViewModel() {

    private val _breeds = MutableLiveData<PagingData<Breed>>()

    val breeds: LiveData<PagingData<Breed>>
        get() = _breeds

    suspend fun getBreeds() {
        viewModelScope.launch {
            listBreedsUseCase.execute(0)
                .cachedIn(viewModelScope).collectLatest {
                    _breeds.value = it
                }
        }
    }
}