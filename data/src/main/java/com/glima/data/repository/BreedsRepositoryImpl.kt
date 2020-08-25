package com.glima.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.glima.domain.business.model.Breed
import com.glima.domain.business.repository.BreedsRepository
import kotlinx.coroutines.flow.Flow

private const val ITEMS_PER_PAGE = 20

class BreedsRepositoryImpl(private val api: CatApi) : BreedsRepository {
    override suspend fun fetchBreedsByPage(page: Int): Flow<PagingData<Breed>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = { BreedsPagingSource(api) }
        ).flow
    }
}