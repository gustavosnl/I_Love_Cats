package com.glima.domain.business.usecase

import com.glima.domain.business.model.Breed
import com.glima.domain.business.model.BreedImage
import com.glima.domain.business.repository.BreedsRepository
import kotlinx.coroutines.flow.Flow

interface LoadRandomImageForBreedingUseCase : UseCase<String, BreedImage>

class LoadRandomImageForBreedingUseCaseImpl(val repository: BreedsRepository) :
    LoadRandomImageForBreedingUseCase {
    override suspend fun execute(params: String): Flow<BreedImage> {
        return repository.getBreedImage(params)
    }

}