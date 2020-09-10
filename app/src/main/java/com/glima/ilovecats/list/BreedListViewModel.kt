package com.glima.ilovecats.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.glima.domain.business.usecase.FetchBreedsUseCase
import com.glima.ilovecats.BreedVO
import com.glima.ilovecats.asViewObject
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class BreedListViewModel(private val listBreedsUseCase: FetchBreedsUseCase) : ViewModel() {

    private val _breeds = MutableLiveData<PagingData<BreedVO>>()

    val breeds: LiveData<PagingData<BreedVO>>
        get() = _breeds

    init {
        getBreeds()
    }

    fun getBreeds() {
        viewModelScope.launch {
            listBreedsUseCase.execute(0)
                .map { pagingData ->
                    pagingData.map {
                        it.asViewObject()
                    }
                }.cachedIn(viewModelScope)
                .collectLatest {
                    _breeds.value = it
                }
        }
    }
}