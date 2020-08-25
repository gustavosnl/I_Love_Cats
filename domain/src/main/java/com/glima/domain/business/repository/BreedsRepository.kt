package com.glima.domain.business.repository

import com.glima.domain.business.model.Breed
import kotlinx.coroutines.flow.Flow

interface BreedsRepository {

    suspend fun fetchBreedsByPage(page: Int): List<Breed>
}