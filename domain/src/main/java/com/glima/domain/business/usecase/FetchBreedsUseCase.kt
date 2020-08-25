package com.glima.domain.business.usecase

import com.glima.domain.business.model.Breed
import com.glima.domain.business.repository.BreedsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

interface FetchBreedsUseCase : UseCase<Int, Breed>

class FetchBreedsUseCaseImpl(private val repository: BreedsRepository) : FetchBreedsUseCase {
    override suspend fun execute(params: Int): Flow<Breed> {
        return repository.fetchBreedsByPage(params).asFlow()
    }
}