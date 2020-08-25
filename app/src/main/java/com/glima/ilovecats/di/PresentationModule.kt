package com.glima.ilovecats.di

import com.glima.ilovecats.list.BreedListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

object PresentationModule {
    val presentationModule = module {

        viewModel {
            BreedListViewModel(get())
        }
    }
}