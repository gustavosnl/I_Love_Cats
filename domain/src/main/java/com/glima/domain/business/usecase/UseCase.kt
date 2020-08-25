package com.glima.domain.business.usecase

import kotlinx.coroutines.flow.Flow

interface UseCase<in P, R> {
    suspend fun execute(params: P): Flow<R>
}