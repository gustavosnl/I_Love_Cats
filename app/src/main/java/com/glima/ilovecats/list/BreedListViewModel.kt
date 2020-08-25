package com.glima.ilovecats.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.glima.domain.business.model.Breed
import com.glima.domain.business.usecase.FetchBreedsUseCase
import kotlinx.coroutines.flow.Flow

class BreedListViewModel(private val listBreedsUseCase: FetchBreedsUseCase) : ViewModel() {

    suspend fun getBreeds(): Flow<PagingData<Breed>> {
        return listBreedsUseCase.execute(0)
            .cachedIn(viewModelScope)
    }
}