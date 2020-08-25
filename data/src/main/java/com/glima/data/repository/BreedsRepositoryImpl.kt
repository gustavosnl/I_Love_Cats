package com.glima.data.repository

import com.glima.data.domain.asDomain
import com.glima.domain.business.model.Breed
import com.glima.domain.business.repository.BreedsRepository

class BreedsRepositoryImpl(private val api: CatApi) : BreedsRepository {
    override suspend fun fetchBreedsByPage(page: Int): List<Breed> {
        return api.fetchBreedsByPage(page).map { breed ->
            breed.asDomain()
        }
    }
}