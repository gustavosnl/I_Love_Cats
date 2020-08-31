package com.glima.domain.di

import com.glima.domain.business.usecase.FetchBreedsUseCase
import com.glima.domain.business.usecase.FetchBreedsUseCaseImpl
import com.glima.domain.business.usecase.LoadRandomImageForBreedingUseCase
import com.glima.domain.business.usecase.LoadRandomImageForBreedingUseCaseImpl
import org.koin.dsl.module

object DomainModule {
    val domainModule = module {
        single<FetchBreedsUseCase> {
            FetchBreedsUseCaseImpl(get())
        }

        single<LoadRandomImageForBreedingUseCase> {
            LoadRandomImageForBreedingUseCaseImpl(get())
        }
    }
}
