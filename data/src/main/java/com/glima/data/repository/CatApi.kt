package com.glima.data.repository

import com.glima.data.domain.BreedImageResponse
import com.glima.data.domain.BreedResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApi {
    @GET("breeds")
    suspend fun fetchBreedsByPage(
        @Query("page") pageNumber: Int,
        @Query("limit") breedsByPage: Int = 20
    ): List<BreedResponse>

    @GET("images/search")
    suspend fun getBreedImage(
        @Query("breed_ids") breedId : String
    ) : List<BreedImageResponse>
}