package com.glima.data.repository

import androidx.paging.PagingSource
import com.glima.data.domain.asDomain
import com.glima.domain.business.model.Breed

private const val INITIAL_PAGE = 0

class BreedsPagingSource(private val api: CatApi) : PagingSource<Int, Breed>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Breed> {
        val page = params.key ?: INITIAL_PAGE

        return try {
            val result = api.fetchBreedsByPage(pageNumber = page)

            LoadResult.Page(
                data = result.map { it.asDomain() },
                prevKey = if (page == INITIAL_PAGE) null else page - 1,
                nextKey = if (result.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}