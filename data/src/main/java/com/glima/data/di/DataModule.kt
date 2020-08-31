package com.glima.data.di

import com.glima.data.repository.BreedsRepositoryImpl
import com.glima.domain.business.repository.BreedsRepository
import org.koin.dsl.module

object DataModule {
    val dataModule = module {

        single<BreedsRepository> {
            BreedsRepositoryImpl(get())
        }
    }
}