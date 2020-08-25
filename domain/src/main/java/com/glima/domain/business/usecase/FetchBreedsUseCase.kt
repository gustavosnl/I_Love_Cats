package com.glima.domain.business.usecase

import androidx.paging.PagingData
import com.glima.domain.business.model.Breed
import com.glima.domain.business.repository.BreedsRepository
import kotlinx.coroutines.flow.Flow

interface FetchBreedsUseCase : UseCase<Int, PagingData<Breed>>

class FetchBreedsUseCaseImpl(private val repository: BreedsRepository) : FetchBreedsUseCase {
    override suspend fun execute(params: Int): Flow<PagingData<Breed>> {
        return repository.fetchBreedsByPage(params)
    }
}