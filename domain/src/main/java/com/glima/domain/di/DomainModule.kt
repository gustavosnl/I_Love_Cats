package com.glima.domain.di

import com.glima.domain.business.usecase.FetchBreedsUseCase
import com.glima.domain.business.usecase.FetchBreedsUseCaseImpl
import org.koin.dsl.module

object DomainModule {
    val domainModule = module {
        single<FetchBreedsUseCase>{
            FetchBreedsUseCaseImpl(get())
        }

    }
}
