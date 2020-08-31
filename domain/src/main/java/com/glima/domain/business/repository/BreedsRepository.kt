package com.glima.domain.business.repository

import androidx.paging.PagingData
import com.glima.domain.business.model.Breed
import com.glima.domain.business.model.BreedImage
import kotlinx.coroutines.flow.Flow

interface BreedsRepository {

    suspend fun fetchBreedsByPage(page: Int): Flow<PagingData<Breed>>
    suspend fun getBreedImage(breedId: String): Flow<BreedImage>
}